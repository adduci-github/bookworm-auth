package com.bookworm.bookwormauth.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${test.message}")
    private String message;

    @GetMapping("/test")
    public String test() {
        return message;
    }
}
