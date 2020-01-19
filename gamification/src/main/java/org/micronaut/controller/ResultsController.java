package org.micronaut.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import org.micronaut.domain.Result;
import org.micronaut.domain.ResultTrivia;
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


    @Post(consumes = MediaType.APPLICATION_JSON)
    public HttpStatus save(@Body ResultTrivia resultTrivia) {
        try {
          /*  System.out.println("multiplication here: "+ resultTrivia.getUserId() + " " + resultTrivia.getAttemptId()
            + " " + resultTrivia.getIsCorrect());*/
            Result result = new Result(
                    resultTrivia.getUserId(), resultTrivia.getAttemptId(),
                    resultTrivia.getIsCorrect() == 1 ? true : false
            );

            System.out.println(result);
            resultService.createScoreCard(result);
            return HttpStatus.CREATED;
        } catch (Exception e) {
            return HttpStatus.NOT_IMPLEMENTED;
        }
    }
}
