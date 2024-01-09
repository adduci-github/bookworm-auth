package com.bookworm.bookwormauth.api.adapter.out.persistence.entity;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.config.PasswordConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "worms")
@Getter
@Setter
public class WormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userId;
    @Convert(converter = PasswordConverter.class)
    private String password;
    private String nickname;

    public static WormEntity of(Registration registration) {
        WormEntity wormEntity = new WormEntity();
        wormEntity.setUserId(registration.userId());
        wormEntity.setPassword(registration.password());
        wormEntity.setNickname(registration.nickname());
        return wormEntity;
    }

    public Worm toWorm() {
        return new Worm(id, userId, nickname);
    }
}
