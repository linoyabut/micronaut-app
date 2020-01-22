package org.micronaut.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Total score user has attained so far in the game. Domain used for displaying data
*/


@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GameStats {

    private  Long userId;
    private  int score;
    private  Badge badge;


}
