package org.micronaut.service;

import java.time.LocalDateTime;

public interface TriviaDateFormatter {
    String dateFormat(LocalDateTime localDateTime);
}
