package org.micronaut.service;

import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.ScoreCard;

import java.util.List;

public interface GameService {
    List<ScoreCard> getAllScoreCards();

    List<LeaderBoard> getAllLeaderBoardStats();
}
