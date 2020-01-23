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
public class Response {

    private User user;

    private String question;

    private String choices;

    private String answer;

    private int correctAnswer;
}
