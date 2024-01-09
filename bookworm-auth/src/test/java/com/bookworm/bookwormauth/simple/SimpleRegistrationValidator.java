package com.bookworm.bookwormauth.simple;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.port.out.ValidationPort;

public class SimpleRegistrationValidator implements ValidationPort {
    @Override
    public boolean validate(Registration command) {
        return command != null;
    }
}
