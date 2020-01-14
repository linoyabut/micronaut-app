package org.micronaut.service;

import org.micronaut.domain.MultiplicationSolved;

public interface ResultService {

    void createScoreCard (MultiplicationSolved multiplicationSolved);

    int calculateScore(boolean correct);
}
