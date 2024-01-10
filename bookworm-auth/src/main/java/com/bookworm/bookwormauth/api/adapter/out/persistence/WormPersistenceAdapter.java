package com.bookworm.bookwormauth.api.adapter.out.persistence;

import com.bookworm.bookwormauth.api.adapter.out.persistence.entity.WormEntity;
import com.bookworm.bookwormauth.api.adapter.out.persistence.repository.WormRepository;
import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.exception.DuplicateUserIdException;
import com.bookworm.bookwormauth.api.application.message.MessageKey;
import com.bookworm.bookwormauth.api.application.port.out.MessageProvidePort;
import com.bookworm.bookwormauth.api.application.port.out.QueryWormPort;
import com.bookworm.bookwormauth.api.application.port.out.WormPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WormPersistenceAdapter implements WormPersistencePort, QueryWormPort {
    private final WormRepository wormRepository;
    private final MessageProvidePort messageProvidePort;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Worm persist(Registration registration) {
        try {
            return persistWormEntity(registration);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserIdException(messageProvidePort.getMessage(MessageKey.REGISTRATION_FAIL_DUPLICATE_USER_ID));
        }
    }

    private Worm persistWormEntity(Registration registration) {
        WormEntity wormEntity = WormEntity.of(registration);
        return wormRepository.save(wormEntity).toWorm();
    }

    @Override
    public Optional<Worm> findByUserIdAndPassword(String userId, String password) {
        return Optional.ofNullable(wormRepository.findByUserId(userId))
                .filter(wormEntity -> passwordEncoder.matches(password, wormEntity.getPassword()))
                .map(WormEntity::toWorm);
    }
}
