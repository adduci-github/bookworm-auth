package com.bookworm.bookwormauth.api.application.domain;

public record Token(String accessToken, String refreshToken) {
}
