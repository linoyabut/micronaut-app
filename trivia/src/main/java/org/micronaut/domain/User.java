package org.micronaut.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class User {

    private String name;
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    // Empty constructor for JSON/JPA
    public User() {
        name = null;
    }
}
