package org.micronaut.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.micronaut.domain.ScoreCard;

/*
Basic Crud Operations for Score Card
*/
@Repository
public interface ScoreCardRepository extends CrudRepository<ScoreCard, Long> {


    public int findSumScoreByUserId(long userId);
}
