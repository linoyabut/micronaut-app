package org.micronaut.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.micronaut.domain.Response;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;
import org.micronaut.service.TriviaDateFormatter;
import org.micronaut.service.TriviaResponseChecker;
import org.micronaut.service.TriviaResultService;

import java.time.LocalDateTime;
import java.util.List;

@Controller("/results")
@Validated
public class TriviaResultController {

    private TriviaResultService triviaResultService;

    private GamificationClient gamificationClient;

    private TriviaResponseChecker triviaResponseChecker;

    private TriviaDateFormatter triviaDateFormatter;

    public TriviaResultController(TriviaResultService triviaResultService, GamificationClient gamificationClient,
                                  TriviaResponseChecker triviaResponseChecker, TriviaDateFormatter triviaDateFormatter) {
        this.triviaResultService = triviaResultService;
        this.gamificationClient = gamificationClient;
        this.triviaResponseChecker = triviaResponseChecker;
        this.triviaDateFormatter = triviaDateFormatter;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpStatus save(@Body Response response) {
        int isCorrect = triviaResponseChecker.checkResponse(response);

        int randomAttemptId = (int)Math.random();

        LocalDateTime localDateTime = LocalDateTime.now();

        ResultAttempt resultAttempt = new ResultAttempt(
        response.getUser(), localDateTime, response.getQuestion(), response.getAnswer(),
                randomAttemptId, isCorrect == 1 ? true: false
        );

        ResultAttempt result = triviaResultService.postTriviaResults(resultAttempt);

        System.out.println(result);
        gamificationClient.save(result.getUser().getId(), randomAttemptId, isCorrect);
        return HttpStatus.CREATED;
    }


    @Get(value = "/users/{name}", produces = MediaType.APPLICATION_JSON)
    public List<ResultAttemptDTO> getTrivia(@PathVariable String name) {
        return triviaResultService.getResults(name);
    }
}
