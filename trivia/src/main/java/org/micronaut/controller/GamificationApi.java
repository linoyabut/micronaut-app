package org.micronaut.controller;

import io.micronaut.http.annotation.Post;
import io.reactivex.Single;
import org.micronaut.domain.Result;

public interface GamificationApi {

    @Post
    Result save(long userId, long attemptId, Boolean result);
}
