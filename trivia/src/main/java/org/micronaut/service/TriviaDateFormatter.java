package org.micronaut.service;

import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TriviaDateFormatter {
    String dateFormat(LocalDateTime localDateTime);

    List<ResultAttemptDTO> resultAttemptDTOList(List<ResultAttempt> resultAttempts);

     ResultAttemptDTO resultAttemptDTO(ResultAttempt resultAttempt);
}
