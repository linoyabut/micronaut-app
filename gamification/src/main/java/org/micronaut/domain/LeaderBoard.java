package org.micronaut.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

/*
Used for displaying only the score for each user
*/

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class LeaderBoard {

    private final Long userId;
    private final Long totalScore;

    public LeaderBoard() {
        this(0L, 0L);
    }


}
