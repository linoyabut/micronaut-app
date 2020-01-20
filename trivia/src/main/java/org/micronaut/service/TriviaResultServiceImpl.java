package org.micronaut.service;

import org.micronaut.domain.Response;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;
import org.micronaut.repository.TriviaResultRepository;

import javax.inject.Singleton;
import java.util.List;


@Singleton
public class TriviaResultServiceImpl implements TriviaResultService {

    private TriviaResultRepository triviaResultRepository;

    private TriviaDateFormatter triviaDateFormatter;

    public TriviaResultServiceImpl(TriviaResultRepository triviaResultRepository
    , TriviaDateFormatter triviaDateFormatter) {
        this.triviaResultRepository = triviaResultRepository;
        this.triviaDateFormatter = triviaDateFormatter;
    }

    @Override
    public ResultAttempt postTriviaResults(ResultAttempt resultAttempt) {
        return triviaResultRepository.save(resultAttempt);
    }

    @Override
    public ResultAttemptDTO getResults(String name) {

        ResultAttempt resultAttempt =  triviaResultRepository.findByUserName(name);

        String date = triviaDateFormatter.dateFormat(resultAttempt.getLocalDateTime());

        ResultAttemptDTO resultAttemptDTO = new ResultAttemptDTO(
            date, resultAttempt.getQuestion(), resultAttempt.getAnswer(), resultAttempt.isCorrect()
        );

        return resultAttemptDTO;
    }
}
