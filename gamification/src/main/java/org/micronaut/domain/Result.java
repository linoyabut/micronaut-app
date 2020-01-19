package org.micronaut.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.*;

import java.io.Serializable;


/*
This Pojo gets the relevant data to calculate the score
*/

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Introspected
public class Result {
    private long userId;
    private long attemptId;
    private boolean isCorrect;
}
