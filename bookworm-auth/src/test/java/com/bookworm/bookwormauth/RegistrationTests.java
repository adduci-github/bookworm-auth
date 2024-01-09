package com.bookworm.bookwormauth;

import com.bookworm.bookwormauth.api.application.domain.Registration;
import com.bookworm.bookwormauth.api.application.domain.Worm;
import com.bookworm.bookwormauth.api.application.exception.DuplicateUserIdException;
import com.bookworm.bookwormauth.api.application.port.in.RegistrationUseCase;
import com.bookworm.bookwormauth.api.application.service.RegistrationService;
import com.bookworm.bookwormauth.simple.SimpleMessageBundle;
import com.bookworm.bookwormauth.simple.SimpleRegistrationValidator;
import com.bookworm.bookwormauth.simple.SimpleWormPersistenceAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTests {
    private final RegistrationUseCase registrationUseCase = new RegistrationService(
            new SimpleRegistrationValidator(), new SimpleMessageBundle(), new SimpleWormPersistenceAdapter());

    @Test
    void registration_command_null_then_throws_exception() {
        assertThrows(IllegalArgumentException.class, () -> registrationUseCase.registration(null));
        assertEquals("REGISTRATION_FAIL_INVALID_STRATEGY", assertThrows(IllegalArgumentException.class, () -> registrationUseCase.registration(null)).getMessage());
    }

    @Test
    void registration_duplicate_user_id_then_thorw_exception() {
        registrationUseCase.registration(new Registration("test", "test", "test"));
        assertThrows(DuplicateUserIdException.class, () -> registrationUseCase.registration(new Registration("test", "test", "test")));
    }

    @Test
    void registration_command_not_null_then_return_worm() {
        Registration command = new Registration("test", "test", "test");
        Worm worm = registrationUseCase.registration(command);

        assertNotNull(worm);
        assertEquals(1L, worm.id());
        assertEquals("test", worm.userId());
        assertEquals("test", worm.nickname());
    }
}
