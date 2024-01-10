package com.bookworm.bookwormauth.api.application.port.out;

import com.bookworm.bookwormauth.api.application.domain.Worm;

import java.util.Optional;

public interface QueryWormPort {
    Optional<Worm> findByUserIdAndPassword(String userId, String password);
}
