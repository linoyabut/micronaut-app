package org.micronaut.domain;


import lombok.*;

/*
Total score user has attained so far in the game. Domain used for displaying data
*/


@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GameStats {
    private Long userId;
    private int score;
    private Badge badge;
}
