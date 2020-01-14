package org.micronaut.domain;


import io.micronaut.core.annotation.Introspected;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



/*
Used for displaying only the score for each user
*/

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Introspected
public class LeaderBoard {

    private final Long userId;
    private final Long score;

    public LeaderBoard() {
        this(0L, 0L);
    }


}
