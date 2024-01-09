package com.bookworm.bookwormauth.api.application.port.out;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;

public interface WormPersistencePort {
    Worm persist(Registration registration);
}
