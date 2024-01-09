package com.bookworm.bookwormauth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "jwt")
@Configuration
@Data
public class JwtConfig {
    private String secret;
    private TokenProperties token;

    @Data
    public static class TokenProperties {
        private ExpirationProperties access;
        private ExpirationProperties refresh;

        @Data
        public static class ExpirationProperties {
            private long expiration;
        }
    }
}
