package com.bookworm.bookwormauth.simple;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.port.out.WormPersistencePort;

public class SimpleWormPersistenceAdapter implements WormPersistencePort {
    @Override
    public Worm persist(Registration registration) {
        return new Worm(1L, registration.userId(), registration.nickname());
    }
}
