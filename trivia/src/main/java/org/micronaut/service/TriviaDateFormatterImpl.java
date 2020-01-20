package org.micronaut.service;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Singleton
public class TriviaDateFormatterImpl implements TriviaDateFormatter {

    @Override
    public String dateFormat(LocalDateTime localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return df.format(localDateTime).toString();
    }
}
