package org.micronaut.service;

import org.micronaut.domain.Result;

public interface ResultService {

    void createScoreCard (Result result);

    int calculateScore(boolean correct);
}
