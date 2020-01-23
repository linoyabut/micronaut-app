package org.micronaut.service;

import org.micronaut.domain.Badge;
import org.micronaut.domain.GameStats;
import org.micronaut.repository.ScoreCardRepository;

import javax.inject.Inject;

/*
Compute the badge for the user based on scores
*/
public class CalculateBadgeServiceImpl implements CalculateBadgeService {

    @Inject
    private ScoreCardRepository scoreCardRepository;

    @Override
    public GameStats computeBatch(long userId) {
        int totalScoreUser = scoreCardRepository.findSumScoreByUserId(userId);
        int totalAttemptUser = scoreCardRepository.countByUserId(userId);

        double scorePercentage = ((totalScoreUser * 100) / (totalAttemptUser * 10));

        Badge badge = BadgeType(scorePercentage);

        GameStats gameStats = new GameStats();
        gameStats.setUserId(userId);
        gameStats.setScore(totalScoreUser);
        gameStats.setBadge(badge);

        return gameStats;
    }

    @Override
    public Badge BadgeType(double scorePercentage) {
        if (scorePercentage > 80) {
            return Badge.GOLD;
        } else if (scorePercentage <= 80 && scorePercentage >= 40) {
            return Badge.SILVER;
        } else {
            return Badge.BRONZE;
        }
    }
}
