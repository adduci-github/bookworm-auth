package com.bookworm.bookwormauth.api.adapter.in.web;

import com.bookworm.bookwormauth.api.adapter.in.web.dto.RegistrationRequest;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.port.in.RegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final RegistrationUseCase registrationUseCase;

    @PostMapping("/registration")
    public ResponseEntity<Worm> registration(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(registrationUseCase.registration(registrationRequest.toRegistration()));
    }
}
