package org.micronaut.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;



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
