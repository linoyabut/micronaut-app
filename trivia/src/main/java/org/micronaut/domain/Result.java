package org.micronaut.domain;


import io.micronaut.core.annotation.Introspected;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Introspected
public class Result {

    private long userId;

    private long attemptId;

    private Boolean isCorrect;
}
