package org.micronaut.service;

import org.micronaut.domain.Response;

import javax.inject.Singleton;

@Singleton
public class TriviaResponseCheckerImpl implements TriviaResponseChecker {

    // check if user's answer is correct
    @Override
    public int checkResponse(Response response) {
        String [] choiceArray = response.getChoices().split("\\|");
        if (choiceArray[response.getCorrectAnswer()].equals(response.getAnswer())) {
            return 1;
        } else
            return 0;
    }

}
