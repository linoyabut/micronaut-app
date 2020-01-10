package org.micronaut.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
Used for displaying the score and the number of attempts (the questions he has answered so far) with the time of getting score and the score he has gotten for each question he answered
*/
@Entity
@Data
@NoArgsConstructor
public class ScoreCard {

    public static final int DEFAULT_SCORE = 10;

    @Id
    @GeneratedValue
    @Column(name = "CARD_ID")
    private Long cardId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ATTEMPT_ID")
    private Long attemptId;

    @Column(name = "SCORE_TS")
    private long scoreTimestamp;

    @Column(name = "SCORE")
    private int score;


    public ScoreCard(Long cardId, Long userId, Long attemptId, long scoreTimestamp, int score) {
        this.cardId = cardId;
        this.userId = userId;
        this.attemptId = attemptId;
        this.scoreTimestamp = System.currentTimeMillis();
        this.score = DEFAULT_SCORE;
    }
}
