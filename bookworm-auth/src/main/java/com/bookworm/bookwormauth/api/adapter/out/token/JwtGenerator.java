package com.bookworm.bookwormauth.api.adapter.out.token;

import com.bookworm.bookwormauth.api.application.domain.Token;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.port.out.TokenGeneratePort;
import com.bookworm.bookwormauth.config.JwtConfig;
import com.bookworm.bookwormauth.util.DateTimeUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtGenerator implements TokenGeneratePort {
    private final Key key;
    private final JwtConfig jwtConfig;

    public JwtGenerator(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtConfig.getSecret()));
    }

    @Override
    public Token generateToken(Worm worm) {
        long now = DateTimeUtil.getCurrentEpochMilli();

        String accessToken = generate(worm.userId(), now, now + jwtConfig.getToken().getAccess().getExpiration());
        String refreshToken = generate(worm.userId(), now, now + jwtConfig.getToken().getRefresh().getExpiration());

        return new Token(accessToken, refreshToken);
    }

    private String generate(String subject, long issuedAt, long expiration) {
        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date(issuedAt))
                .expiration(new Date(expiration))
                .signWith(key)
                .compact();
    }
}
