package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Introspected
public class ResultAttemptDTO {

    private String localDateTime;

    private String question;

    private String answer;

    private String isCorrect;

}
