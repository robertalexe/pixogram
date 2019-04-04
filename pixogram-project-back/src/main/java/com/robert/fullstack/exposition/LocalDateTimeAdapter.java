package com.robert.fullstack.exposition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class LocalDateTimeAdapter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private LocalDateTimeAdapter() {}

    public static String dateTimeToStringFormatter(LocalDateTime date) {
        return Objects.isNull(date) ? "" : date.format(FORMATTER);
    }
}
