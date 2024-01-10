package com.bookworm.bookwormauth.api.application.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundWormException extends RuntimeException {
    public NotFoundWormException(String message) {
        super(message);
    }
}
