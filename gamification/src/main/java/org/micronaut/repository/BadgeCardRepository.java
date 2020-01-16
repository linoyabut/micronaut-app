package org.micronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.micronaut.domain.BadgeCard;

import javax.persistence.EntityManager;
import java.util.List;

/*
CRUD operations for BatchCard
 */
@Repository
public interface  BadgeCardRepository extends CrudRepository<BadgeCard, Long> {

    /*
Retrieves all the badgecards in the database for display based on the userId
    */
    public List<BadgeCard> findByUserId(Long userId);


}
