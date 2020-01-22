package org.micronaut.service;

import org.micronaut.domain.Badge;
import org.micronaut.domain.GameStats;

public interface CalculateBadgeService {
    GameStats computeBatch(long userId);

    Badge BadgeType(double scorePercentage);
}
