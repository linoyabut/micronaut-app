package org.micronaut.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.micronaut.domain.Response;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;
import org.micronaut.domain.User;
import org.micronaut.repository.UserRepository;
import org.micronaut.service.TriviaDateFormatter;
import org.micronaut.service.TriviaResponseChecker;
import org.micronaut.service.TriviaResultService;
import org.micronaut.service.TriviaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller("/results")
@Validated
public class TriviaResultController {

    private TriviaResultService triviaResultService;

    private GamificationClient gamificationClient;

    private TriviaResponseChecker triviaResponseChecker;

    private TriviaDateFormatter triviaDateFormatter;

    private UserRepository userRepository;

    private TriviaService triviaService;

    public TriviaResultController(TriviaResultService triviaResultService, GamificationClient gamificationClient,
                                  TriviaResponseChecker triviaResponseChecker, TriviaDateFormatter triviaDateFormatter,
                                  UserRepository userRepository, TriviaService triviaService) {
        this.triviaResultService = triviaResultService;
        this.gamificationClient = gamificationClient;
        this.triviaResponseChecker = triviaResponseChecker;
        this.triviaDateFormatter = triviaDateFormatter;
        this.userRepository = userRepository;
        this.triviaService = triviaService;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ResultAttemptDTO> save(@Body Response response) {
        //User user1 = new User();

        /*Check if the user exists in the database by name, if exists, persist response to existing user*/
        Optional<User> user = userRepository.findByName(response.getUser().getName());

     /*   if(user.isEmpty()) {
            user1 = userRepository.save(response.getUser());
        } else {
            user1 = user.get();
        }*/

        int isCorrect = triviaResponseChecker.checkResponse(response);

        /*Creates a new resultAttempt */
        ResultAttempt resultAttempt = new ResultAttempt(
                user.orElse(response.getUser()),
                LocalDateTime.now(),
                response.getQuestion(),
                response.getAnswer(),
                triviaService.generateAttemptId(),
                isCorrect == 1);

        ResultAttempt result = triviaResultService.postTriviaResults(resultAttempt);

        gamificationClient.save(result.getUser().getId(), triviaService.generateAttemptId(), isCorrect);

        ResultAttemptDTO resultAttemptDTO = triviaDateFormatter.resultAttemptDTO(resultAttempt);
        return HttpResponse.ok(resultAttemptDTO);
    }


    @Get(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON)
    public List<ResultAttemptDTO> getTrivia(@PathVariable long userId) {
        return triviaResultService.getResults(userId);
    }
}
