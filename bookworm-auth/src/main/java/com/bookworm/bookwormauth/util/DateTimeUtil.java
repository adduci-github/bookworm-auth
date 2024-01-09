package com.bookworm.bookwormauth.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {
    public static long getCurrentEpochMilli() {
        return LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
    }
}
