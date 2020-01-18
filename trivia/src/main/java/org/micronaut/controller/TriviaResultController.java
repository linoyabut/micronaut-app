package org.micronaut.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.micronaut.domain.Response;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.service.TriviaResponseChecker;
import org.micronaut.service.TriviaResultService;

import java.util.List;

@Controller("/results")
@Validated
public class TriviaResultController {

    private TriviaResultService triviaResultService;

    private GamificationClient gamificationClient;

    private TriviaResponseChecker triviaResponseChecker;

    public TriviaResultController(TriviaResultService triviaResultService, GamificationClient gamificationClient, TriviaResponseChecker triviaResponseChecker) {
        this.triviaResultService = triviaResultService;
        this.gamificationClient = gamificationClient;
        this.triviaResponseChecker = triviaResponseChecker;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpStatus save(@Body Response response) {
        boolean isCorrect = triviaResponseChecker.checkResponse(response);

        ResultAttempt resultAttempt = new ResultAttempt(
        response.getUser(), response.getQuestion(), response.getAnswer(),
                response.getAttemptId(), isCorrect
        );

        ResultAttempt result = triviaResultService.postTriviaResults(resultAttempt);

        gamificationClient.save(result.getUser().getId(), result.getAttemptId(), result.isCorrect());
        return HttpStatus.CREATED;
    }


    @Get(value = "/users/{name}", produces = MediaType.APPLICATION_JSON)
    public List<ResultAttempt> getTrivia(@PathVariable String name) {
        return triviaResultService.getResults(name);
    }
}
