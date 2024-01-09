package com.bookworm.bookwormauth.api.adapter.in.web;

import com.bookworm.bookwormauth.api.adapter.out.token.JwtGenerator;
import com.bookworm.bookwormauth.api.application.domain.Token;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final JwtGenerator jwtGenerator;

    @GetMapping("/test")
    public Token test() {
        return jwtGenerator.generateToken(new Worm("test", "test"));
    }
}
