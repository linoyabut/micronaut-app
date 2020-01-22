package org.micronaut.domain;


import io.micronaut.core.annotation.Introspected;
import lombok.*;



/*
Used for displaying only the score for each user
*/

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class LeaderBoard {

    private String userId;
    private String totalScore;

}
