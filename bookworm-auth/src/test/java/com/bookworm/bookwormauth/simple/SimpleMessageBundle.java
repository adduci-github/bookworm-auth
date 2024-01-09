package com.bookworm.bookwormauth.simple;

import com.bookworm.bookwormauth.api.application.message.MessageKey;
import com.bookworm.bookwormauth.api.application.port.out.MessageProvidePort;

public class SimpleMessageBundle implements MessageProvidePort {
    @Override
    public String getMessage(MessageKey key) {
        return key.name();
    }
}
