package org.micronaut.domain;


import io.micronaut.core.annotation.Introspected;
import lombok.*;



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
