package com.bookworm.bookwormauth.api.adapter.in.web;

import com.bookworm.bookwormauth.api.adapter.in.web.dto.response.CommonResponse;
import com.bookworm.bookwormauth.api.application.exception.DuplicateUserIdException;
import com.bookworm.bookwormauth.api.application.exception.NotFoundWormException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CommonResponse<String>> handleIllegalArgumentException(IllegalArgumentException e) {
        CommonResponse<String> response = new CommonResponse<>();
        response.setMessage(e.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(DuplicateUserIdException.class)
    public ResponseEntity<CommonResponse<String>> handleDuplicateUserIdException(DuplicateUserIdException e) {
        CommonResponse<String> response = new CommonResponse<>();
        response.setMessage(e.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NotFoundWormException.class)
    public ResponseEntity<CommonResponse<String>> handleNotFoundWormException(NotFoundWormException e) {
        CommonResponse<String> response = new CommonResponse<>();
        response.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
