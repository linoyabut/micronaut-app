package org.micronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.micronaut.domain.BadgeCard;

import java.util.List;

/*
Retrieves all the badgecards in the database for display, sorted with the most recent badgecard
*/
@Repository
public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {

    //ist<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(final long userId);

}
