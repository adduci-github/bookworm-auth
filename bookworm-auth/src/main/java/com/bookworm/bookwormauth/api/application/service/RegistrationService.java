package com.bookworm.bookwormauth.api.application.service;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.message.MessageKey;
import com.bookworm.bookwormauth.api.application.port.in.RegistrationUseCase;
import com.bookworm.bookwormauth.api.application.port.out.MessageProvidePort;
import com.bookworm.bookwormauth.api.application.port.out.ValidationPort;
import com.bookworm.bookwormauth.api.application.port.out.WormPersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegistrationService implements RegistrationUseCase {
    private final ValidationPort validationPort;
    private final MessageProvidePort messageProvidePort;
    private final WormPersistencePort wormPersistencePort;

    @Override
    public Worm registration(Registration command) {
        log.info("registration command: {}", command);

        if(!validationPort.validate(command)) {
            throw new IllegalArgumentException(messageProvidePort.getMessage(MessageKey.REGISTRATION_FAIL_INVALID_STRATEGY));
        }

        return wormPersistencePort.persist(command);
    }
}
