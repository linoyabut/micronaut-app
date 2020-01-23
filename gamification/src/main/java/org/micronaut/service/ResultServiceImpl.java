package org.micronaut.service;

import org.micronaut.domain.Result;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;

public class ResultServiceImpl implements ResultService {

    ScoreCardRepository scoreCardRepository;

    public ResultServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }


    @Override
    public void createScoreCard(Result result) {
        try {
            ScoreCard scoreCard = new ScoreCard();
            scoreCard.setAttemptId(result.getAttemptId());
            scoreCard.setUserId(result.getUserId());
            int score = calculateScore(result.isCorrect());
            scoreCard.setScore(score);
            scoreCardRepository.save(scoreCard);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public int calculateScore(boolean correct) {
        return correct == true ? 10 : 0;
    }

}
