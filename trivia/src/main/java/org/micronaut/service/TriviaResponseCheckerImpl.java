package org.micronaut.service;

import org.micronaut.domain.Response;

import javax.inject.Singleton;

@Singleton
public class TriviaResponseCheckerImpl implements TriviaResponseChecker {

    // check if user's answer is correct
    @Override
    public boolean checkResponse(Response response) {
        String [] choiceArray = response.getChoices().split("\\|");
     /*   System.out.println(choiceArray[response.getCorrectAnswer()] + " correct ans");
        System.out.println(response.getAnswer() + " user input");*/
        if (choiceArray[response.getCorrectAnswer()].equals(response.getAnswer())) {
            return true;
        } else
            return false;
    }

}
