package com.bookworm.bookwormauth.api.adapter.in.web.dto.response;

import com.bookworm.bookwormauth.api.application.domain.Token;
import lombok.Data;

@Data
public class TokenResponse {
    private String accessToken;
    private String refreshToken;

    public static TokenResponse of(Token token) {
        TokenResponse response = new TokenResponse();
        response.setAccessToken(token.accessToken());
        response.setRefreshToken(token.refreshToken());

        return response;
    }
}
