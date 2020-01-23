package org.micronaut.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class LeaderBoard {

    private String userId;
    private String totalScore;

}
