package org.micronaut.service;

import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class GameServiceImpl implements GameService {

    private ScoreCardRepository scoreCardRepository;

    public GameServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public List<ScoreCard> getAllScoreCards() {
        return (List) scoreCardRepository.findAll();
    }

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
