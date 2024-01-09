package com.bookworm.bookwormauth.api.adapter.in.web;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.port.in.RegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final RegistrationUseCase registrationUseCase;

    @GetMapping("/test")
    public Worm test() {
        return registrationUseCase.registration(new Registration("test123", "test123123", "test"));
    }
}
