package com.bookworm.bookwormauth.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public final class DateTimeUtils {
    private DateTimeUtils() {}

    public static long getCurrentEpochMilli() {
        return LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
    }
}
