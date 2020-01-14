package org.micronaut.service;

import org.micronaut.domain.ScoreCard;

import java.util.List;

public interface GameService {
    List<ScoreCard> getAllScoreCards();

    int getTotalScore(Long userId);

    public List<Object[]> getLeaderBoardStats();
}
