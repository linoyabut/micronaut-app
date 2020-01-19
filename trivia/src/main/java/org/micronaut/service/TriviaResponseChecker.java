package org.micronaut.service;

import org.micronaut.domain.Response;

public interface TriviaResponseChecker {
    // check if user's answer is correct
    byte checkResponse (Response response);
}
