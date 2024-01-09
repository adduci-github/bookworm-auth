package com.bookworm.bookwormauth.api.application.port.in;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;

public interface RegistrationUseCase {
    Worm registration(Registration command);
}
