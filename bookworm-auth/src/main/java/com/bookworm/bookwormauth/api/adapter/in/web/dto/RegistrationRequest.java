package com.bookworm.bookwormauth.api.adapter.in.web.dto;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationRequest {
    @NotNull(message = "아이디를 입력해주세요.")
    @Size(min = 4, max = 10, message = "아이디는 4자 이상 10자 이하로 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디는 영문자와 숫자만 입력해주세요.")
    private String userId;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String password;

    @NotNull(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
    private String nickname;

    public Registration toRegistration() {
        return new Registration(userId, password, nickname);
    }
}
