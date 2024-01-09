package com.bookworm.bookwormauth.api.application.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DuplicateUserIdException extends RuntimeException {
    public DuplicateUserIdException(String message) {
        super(message);
    }
}
