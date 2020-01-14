package org.micronaut.service;

import org.micronaut.domain.MultiplicationSolved;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;

import javax.inject.Inject;

public class ResultServiceImpl implements ResultService {

    @Inject
    ScoreCardRepository scoreCardRepository;


    @Override
    public void createScoreCard(MultiplicationSolved multiplicationSolved) {
        try {
            ScoreCard scoreCard = new ScoreCard();
            scoreCard.setAttemptId(multiplicationSolved.getAttemptId());
            scoreCard.setUserId(multiplicationSolved.getUserId());
            int score = calculateScore(multiplicationSolved.isCorrect());
            scoreCard.setScore(score);
            scoreCardRepository.save(scoreCard);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public int calculateScore(boolean correct) {
        return correct ? 10 : 0;
    }

}
