package org.micronaut.service;

import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

/*
Service layer for Score-Card
*/
@Singleton
public class GameServiceImpl implements GameService {

    @Inject
    private ScoreCardRepository scoreCardRepository;

    @Override
    public List<ScoreCard> getAllScoreCards() {
        return (List) scoreCardRepository.findAll();
    }

    /*
     * Mapping the Object [], returned from database with userid and score to leaderboard obj
     **/
    @Override
    public List<LeaderBoard> getAllLeaderBoardStats() {
        List<Object[]> leaderBoardResults = scoreCardRepository.findAllLeaders();

        List<LeaderBoard> leaderBoardList = new LinkedList<>();

        for (Object[] obj : leaderBoardResults) {
            Long userId = (Long) obj[0];
            Long totalScore = (Long) obj[1];
            String uId = String.valueOf(userId);
            String ttlScore = String.valueOf(totalScore);
            LeaderBoard leaderBoard = new LeaderBoard(uId, ttlScore);
            leaderBoardList.add(leaderBoard);
        }

        return leaderBoardList;
    }

}
