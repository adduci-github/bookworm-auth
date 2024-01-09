package com.bookworm.bookwormauth.api.application.port.in;

import com.bookworm.bookwormauth.api.application.domain.Token;

public interface AuthenticationUseCase {
    Token authenticate(String userId, String password);
}
