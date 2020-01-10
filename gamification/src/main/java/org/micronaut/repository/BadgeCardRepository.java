package org.micronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.micronaut.domain.BadgeCard;

@Repository
public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {

}
