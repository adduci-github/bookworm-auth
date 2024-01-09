package com.bookworm.bookwormauth.api.adapter.out.validation;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.port.out.ValidationPort;
import com.bookworm.bookwormauth.config.RegistrationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrationValidator implements ValidationPort {
    private final RegistrationConfig registrationConfig;

    @Override
    public boolean validate(Registration command) {
        return command != null && validateUserId(command.userId()) && validatePassword(command.password()) && validateNickname(command.nickname());
    }

    private boolean validateUserId(String userId) {
        if(!isWithinLengthLimit(userId, registrationConfig.getUserId().getMinLength(), registrationConfig.getUserId().getMaxLength())) {
            return false;
        }
        return userId.matches(registrationConfig.getUserId().getRegex());
    }

    private boolean validatePassword(String password) {
        return isWithinLengthLimit(password, registrationConfig.getPassword().getMinLength(), registrationConfig.getPassword().getMaxLength());
    }

    private boolean validateNickname(String nickname) {
        return isWithinLengthLimit(nickname, registrationConfig.getNickname().getMinLength(), registrationConfig.getNickname().getMaxLength());
    }

    private boolean isWithinLengthLimit(String s, int minLength, int maxLength) {
        return s.length() > minLength && s.length() < maxLength;
    }
}
