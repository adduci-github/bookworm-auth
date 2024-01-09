package com.bookworm.bookwormauth.api.application.port.out;

import com.bookworm.bookwormauth.api.application.domain.Registration;

public interface ValidationPort {
    boolean validate(Registration command);
}
