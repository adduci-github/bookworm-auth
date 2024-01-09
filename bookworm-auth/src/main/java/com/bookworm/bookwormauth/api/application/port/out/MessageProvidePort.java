package com.bookworm.bookwormauth.api.application.port.out;

import com.bookworm.bookwormauth.api.application.message.MessageKey;

public interface MessageProvidePort {
    String getMessage(MessageKey key);
}
