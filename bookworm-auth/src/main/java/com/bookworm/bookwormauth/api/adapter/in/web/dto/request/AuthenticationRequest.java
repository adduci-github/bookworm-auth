package com.bookworm.bookwormauth.api.adapter.in.web.dto.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String userId;
    private String password;
}
