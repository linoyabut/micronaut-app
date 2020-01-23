package org.micronaut.controller;

import io.micronaut.http.HttpResponse;
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

import java.util.List;

@Controller("/scorecard")
@Validated
public class ScoreCardController {


    private CalculateBadgeService calculateBadgeService;

    private GameService gameService;

    public ScoreCardController(CalculateBadgeService calculateBadgeService, GameService gameService) {
        this.calculateBadgeService = calculateBadgeService;
        this.gameService = gameService;
    }

    @Get(value = "allcards", produces = MediaType.APPLICATION_JSON)
    public List<ScoreCard> getAllScoreCard() {
        return gameService.getAllScoreCards();
    }


    @Get(value = "/leaderboard", produces = MediaType.APPLICATION_JSON)
    public List<LeaderBoard> leaderBoardScores() {
        return gameService.getAllLeaderBoardStats();
    }

    @Get(value = "/gamestats/{userId}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<GameStats> gameStatsUser(@PathVariable Long userId) {
        GameStats gameStats = calculateBadgeService.computeBatch(userId);
        return HttpResponse.ok(gameStats);
    }


}
