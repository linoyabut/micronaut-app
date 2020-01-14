package org.micronaut.domain;

import lombok.*;


/*
This Pojo gets the relevant data to calculate the score
*/

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolved {

    private long attemptId;
    private long userId;
    private boolean correct;
}
