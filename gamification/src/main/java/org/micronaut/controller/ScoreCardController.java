package org.micronaut.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.validation.Validated;
import org.micronaut.domain.GameStats;
import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.ScoreCard;
import org.micronaut.service.CalculateBadgeService;
import org.micronaut.service.GameService;

import javax.inject.Inject;
import java.util.List;

@Controller("/scorecard")
@Validated
public class ScoreCardController {

    @Inject
    private GameService gameService;

    @Inject
    CalculateBadgeService calculateBadgeService;


    @Get(value = "allcards",produces = MediaType.APPLICATION_JSON)
    public List<ScoreCard> getAllScoreCard(){
        return gameService.getAllScoreCards();
    }


    @Get(value = "/leaderboard",produces = MediaType.APPLICATION_JSON)
    public List<LeaderBoard> leaderBoardScores(){
        return gameService.getAllLeaderBoardStats();
    }

    @Get(value = "/gamestats/{userId}",produces = MediaType.APPLICATION_JSON)
    public GameStats gameStatsUser(Long userId){
        return calculateBadgeService.computeBatch(userId);
    }


}
