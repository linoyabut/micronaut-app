package org.micronaut.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import org.micronaut.domain.Result;
import org.micronaut.domain.ResultTrivia;
import org.micronaut.service.ResultService;


@Controller("/results")
@Validated
public class ResultsController {

    private ResultService resultService;

    public ResultsController(ResultService resultService) {
        this.resultService = resultService;
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Result> save(@Body ResultTrivia resultTrivia) {
        try {
            Result result = new Result(resultTrivia.getUserId(), resultTrivia.getAttemptId(),
                    resultTrivia.getIsCorrect() == 1 ? true: false);
            resultService.createScoreCard(result);
            return HttpResponse.ok(result);
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }
}
