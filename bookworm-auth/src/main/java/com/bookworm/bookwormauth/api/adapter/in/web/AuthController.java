package com.bookworm.bookwormauth.api.adapter.in.web;

import com.bookworm.bookwormauth.api.adapter.in.web.dto.request.AuthenticationRequest;
import com.bookworm.bookwormauth.api.adapter.in.web.dto.request.RegistrationRequest;
import com.bookworm.bookwormauth.api.adapter.in.web.dto.response.CommonResponse;
import com.bookworm.bookwormauth.api.adapter.in.web.dto.response.TokenResponse;
import com.bookworm.bookwormauth.api.adapter.in.web.dto.response.WormResponse;
import com.bookworm.bookwormauth.api.application.domain.Token;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.port.in.AuthenticationUseCase;
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
    private final AuthenticationUseCase  authenticationUseCase;

    @PostMapping("/registration")
    public ResponseEntity<CommonResponse<WormResponse>> registration(@RequestBody RegistrationRequest registrationRequest) {
        CommonResponse<WormResponse> response = new CommonResponse<>();
        response.setData(WormResponse.of(registrationUseCase.registration(registrationRequest.toRegistration())));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/authentication")
    public ResponseEntity<CommonResponse<TokenResponse>> authentication(@RequestBody AuthenticationRequest authenticationRequest) {
        CommonResponse<TokenResponse> response = new CommonResponse<>();
        response.setData(TokenResponse.of(authenticationUseCase.authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword())));

        return ResponseEntity.ok(response);
    }
}
