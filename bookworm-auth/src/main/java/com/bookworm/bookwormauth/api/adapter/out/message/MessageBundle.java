package com.bookworm.bookwormauth.api.adapter.out.message;

import com.bookworm.bookwormauth.api.application.message.MessageKey;
import com.bookworm.bookwormauth.api.application.port.out.MessageProvidePort;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class MessageBundle implements MessageProvidePort {
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.KOREA);

    @Override
    public String getMessage(MessageKey key) {
        return bundle.getString(key.toString());
    }
}
