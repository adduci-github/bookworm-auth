package com.bookworm.bookwormauth.api.application.service;

import com.bookworm.bookwormauth.api.application.domain.Token;
import com.bookworm.bookwormauth.api.application.exception.NotFoundWormException;
import com.bookworm.bookwormauth.api.application.message.MessageKey;
import com.bookworm.bookwormauth.api.application.port.in.AuthenticationUseCase;
import com.bookworm.bookwormauth.api.application.port.out.MessageProvidePort;
import com.bookworm.bookwormauth.api.application.port.out.QueryWormPort;
import com.bookworm.bookwormauth.api.application.port.out.TokenGeneratePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {
    private final QueryWormPort queryWormPort;
    private final TokenGeneratePort tokenGeneratePort;
    private final MessageProvidePort messageProvidePort;

    @Override
    public Token authenticate(String userId, String password) {
        return queryWormPort.findByUserIdAndPassword(userId, password)
                .map(tokenGeneratePort::generateToken)
                .orElseThrow(() -> new NotFoundWormException(messageProvidePort.getMessage(MessageKey.AUTHENTICATION_FAIL_NOT_FOUND)));
    }
}
