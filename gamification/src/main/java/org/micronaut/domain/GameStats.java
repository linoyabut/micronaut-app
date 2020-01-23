package org.micronaut.domain;


import lombok.*;


@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GameStats {
    private Long userId;
    private int score;
    private Badge badge;
}
