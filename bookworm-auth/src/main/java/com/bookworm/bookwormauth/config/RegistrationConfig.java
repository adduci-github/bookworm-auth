package com.bookworm.bookwormauth.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "registration-strategy")
@Configuration
@Data
public class RegistrationConfig {
    private UserId userId;
    private Password password;
    private Nickname nickname;

    @Data
    private static class Strategy {
        private int minLength;
        private int maxLength;
    }

    @Setter
    @Getter
    public static class UserId extends Strategy {
        private String regex;
    }

    public static class Password extends Strategy {
    }

    public static class Nickname extends Strategy {
    }
}
