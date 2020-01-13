package org.micronaut.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


/*
This Pojo gets the relevant data to calculate the score
*/
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolved {

    private final long attemptId;
    private final long userId;
    private final boolean correct;
}
