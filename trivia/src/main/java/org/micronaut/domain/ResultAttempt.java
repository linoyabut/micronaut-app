package org.micronaut.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    private LocalDateTime localDateTime;

    private String question;

    private String answer;

    private int attemptId;

    private boolean isCorrect;

    public ResultAttempt(User user, LocalDateTime localDateTime, String question, String answer, int attemptId, boolean isCorrect) {
        this.user = user;
        this.localDateTime = localDateTime;
        this.question = question;
        this.answer = answer;
        this.attemptId = attemptId;
        this.isCorrect = isCorrect;
    }
}
