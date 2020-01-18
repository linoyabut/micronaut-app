package org.micronaut.service;

import org.micronaut.domain.Response;

public interface TriviaResponseChecker {
    // check if user's answer is correct
    boolean checkResponse (Response response);
}
