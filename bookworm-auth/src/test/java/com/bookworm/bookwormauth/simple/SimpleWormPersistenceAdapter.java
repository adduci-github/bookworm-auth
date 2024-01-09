package com.bookworm.bookwormauth.simple;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.exception.DuplicateUserIdException;
import com.bookworm.bookwormauth.api.application.port.out.WormPersistencePort;

public class SimpleWormPersistenceAdapter implements WormPersistencePort {
    private static String userId;

    @Override
    public Worm persist(Registration registration) {
        if(registration.userId().equals(userId)) {
            userId = null;
            throw new DuplicateUserIdException();
        }

        userId = registration.userId();

        return new Worm(1L, registration.userId(), registration.nickname());
    }
}
