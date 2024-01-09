package com.bookworm.bookwormauth.api.application.service;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.message.MessageKey;
import com.bookworm.bookwormauth.api.application.port.in.RegistrationUseCase;
import com.bookworm.bookwormauth.api.application.port.out.MessageProvidePort;
import com.bookworm.bookwormauth.api.application.port.out.ValidationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrationService implements RegistrationUseCase {
    private final ValidationPort validationPort;
    private final MessageProvidePort messageProvidePort;

    @Override
    public Worm registration(Registration command) {
        if(!validationPort.validate(command)) {
            throw new IllegalArgumentException(messageProvidePort.getMessage(MessageKey.REGISTRATION_FAIL_INVALID_STRATEGY));
        }

        return new Worm(1L, command.userId(), command.nickname());
    }
}
