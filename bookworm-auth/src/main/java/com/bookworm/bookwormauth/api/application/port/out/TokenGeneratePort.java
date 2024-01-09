package com.bookworm.bookwormauth.api.application.port.out;

import com.bookworm.bookwormauth.api.application.domain.Token;
import com.bookworm.bookwormauth.api.application.domain.Worm;

public interface TokenGeneratePort {
    Token generateToken(Worm worm);
}
