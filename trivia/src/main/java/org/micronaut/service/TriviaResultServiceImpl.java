package org.micronaut.service;

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
    public List<ResultAttemptDTO> getResults(long userId) {

        List<ResultAttempt> resultAttempts = triviaResultRepository.findByUserId(userId);

        return triviaDateFormatter.resultAttemptDTOList(resultAttempts);
    }
}
