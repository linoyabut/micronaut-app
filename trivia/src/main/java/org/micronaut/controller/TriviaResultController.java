package org.micronaut.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.service.TriviaResultService;

import java.util.List;

@Controller("/results")
@Validated
public class TriviaResultController {

    private TriviaResultService triviaResultService;

    private GamificationClient gamificationClient;

    public TriviaResultController(TriviaResultService triviaResultService, GamificationClient gamificationClient) {
        this.triviaResultService = triviaResultService;
        this.gamificationClient = gamificationClient;
    }

    @Post
    public HttpStatus save(@Body ResultAttempt resultAttempt) {

        ResultAttempt result = triviaResultService.postTriviaResults(resultAttempt);
        System.out.println(result.getUser().getId());
        gamificationClient.save(result.getUser().getId(), result.getUser().getId() , result.isResult());
        return HttpStatus.CREATED;
    }


    @Get(value = "/users/{name}", produces = MediaType.APPLICATION_JSON)
    public List<ResultAttempt> getTrivia(@PathVariable String name) {
        return triviaResultService.getResults(name);
    }
}
