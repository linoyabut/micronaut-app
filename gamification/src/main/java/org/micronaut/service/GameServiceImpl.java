package org.micronaut.service;

import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
/*
Service layer for Score-Card
*/
@Singleton
public class GameServiceImpl implements GameService {

    private ScoreCardRepository scoreCardRepository;



    public GameServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public List<ScoreCard> getAllScoreCards() {
       return (List)scoreCardRepository.findAll();
    }

    @Override
    public int getTotalScore(Long userId) {
       return scoreCardRepository.findSumScoreByUserId(userId);
    }

    @Override
    @Transactional
    public List<Object[]> getLeaderBoardStats() {
        return scoreCardRepository.findAllLeaders();
    }
}
