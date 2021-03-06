package org.micronaut.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class BadgeCard {

    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    private Long badgeId;

    private Long userId;
    private Badge badge;


    public BadgeCard() {
        this(null, null);
    }

    public BadgeCard(final Long userId, final Badge badge) {
        this(null, userId, badge);
    }

}
