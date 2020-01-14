package org.micronaut.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import org.micronaut.domain.MultiplicationSolved;
import org.micronaut.service.GameService;
import org.micronaut.service.ResultService;

import javax.inject.Inject;

@Controller("/results")
@Validated
public class ResultsController {

    @Inject
    ResultService resultService;

/*
* Persist results object to the back-end to compute score, create scorecard and create badge
* */

    @Post
    public HttpStatus save(@Body MultiplicationSolved multiplicationSolved) {
        System.out.println(multiplicationSolved);
        resultService.createScoreCard(multiplicationSolved);
        return HttpStatus.CREATED;
    }
}
