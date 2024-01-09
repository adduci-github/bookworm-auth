package com.bookworm.bookwormauth.api.adapter.out.persistence;

import com.bookworm.bookwormauth.api.adapter.out.persistence.entity.WormEntity;
import com.bookworm.bookwormauth.api.adapter.out.persistence.repository.WormRepository;
import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.exception.DuplicateUserIdException;
import com.bookworm.bookwormauth.api.application.message.MessageKey;
import com.bookworm.bookwormauth.api.application.port.out.MessageProvidePort;
import com.bookworm.bookwormauth.api.application.port.out.WormPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WormPersistenceAdapter implements WormPersistencePort {
    private final WormRepository wormRepository;
    private final MessageProvidePort messageProvidePort;

    @Override
    @Transactional
    public Worm persist(Registration registration) {
        WormEntity wormEntity = WormEntity.of(registration);
        Worm worm;

        try {
            worm = wormRepository.save(wormEntity).toWorm();
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserIdException(messageProvidePort.getMessage(MessageKey.REGISTRATION_FAIL_DUPLICATE_USER_ID));
        }

        return worm;
    }
}
