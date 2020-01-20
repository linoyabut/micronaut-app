package org.micronaut.service;

import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class TriviaDateFormatterImpl implements TriviaDateFormatter {



    @Override
    public String dateFormat(LocalDateTime localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return df.format(localDateTime).toString();
    }

    @Override
    public List<ResultAttemptDTO> resultAttemptDTOList(List<ResultAttempt> resultAttempts) {
        List<ResultAttemptDTO> resultAttemptDTOS = new LinkedList<>();
        for(ResultAttempt resultAttempt: resultAttempts) {
            String date = dateFormat(resultAttempt.getLocalDateTime());

            ResultAttemptDTO resultAttemptDTO = new ResultAttemptDTO(
                    date, resultAttempt.getQuestion(), resultAttempt.getAnswer(),
                    String.valueOf(resultAttempt.isCorrect())
            );

            resultAttemptDTOS.add(resultAttemptDTO);
        }

        return resultAttemptDTOS;
    }

}
