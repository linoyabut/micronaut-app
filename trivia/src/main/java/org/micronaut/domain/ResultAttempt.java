package org.micronaut.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@ToString
@EqualsAndHashCode
@Entity
@Getter
public final class ResultAttempt {

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Id
    @GeneratedValue
    private Long id;

   // private Long userId;
    private LocalDateTime localDateTime;
    private String question;
    private String answer;
    private int attemptId;
    private boolean isCorrect;


    public ResultAttempt(User user,
                         LocalDateTime localDateTime,
                         String question,
                         String answer,
                         int attemptId,
                         boolean isCorrect) {
        this.user = user;
        this.localDateTime = localDateTime;
        this.question = question;
        this.answer = answer;
        this.attemptId = attemptId;
        this.isCorrect = isCorrect;
    }

    public ResultAttempt() {
    }
}
