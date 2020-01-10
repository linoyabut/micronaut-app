package org.micronaut.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Total score user has attained so far in the game. Domain used for displaying data
*/


@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class GameStats {


    private final Long userId;
    private final int score;
    private final List<Badge> badges;


    public GameStats() {
        this.userId = 0L;
        this.score = 0;
        this.badges = new ArrayList<>();
    }

    public static GameStats emptyStats(final Long userId) {
        return new GameStats(userId, 0, Collections.emptyList());
    }

    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }
}
