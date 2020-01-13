package org.micronaut;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;


import javax.inject.Singleton;

@Singleton
@Requires(notEnv = Environment.TEST)
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    private ScoreCardRepository scoreCardRepository;

    public DataLoader(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }


    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        /*
        Seeding the ScoreCard table so that can test the repo to see if getting scores possible
        */
        if(scoreCardRepository.count() == 0) {
            ScoreCard scoreCard = new ScoreCard( 1l, 1l, 10);

            ScoreCard scoreCard1 = new ScoreCard( 1l, 2l, 10);

            ScoreCard scoreCard2 = new ScoreCard(1l, 3l, 0);

            ScoreCard scoreCard3 =  new ScoreCard( 1l, 4l, 10);

            ScoreCard scoreCard4 =  new ScoreCard( 1l, 5l, 0);

            scoreCardRepository.save(scoreCard);
            scoreCardRepository.save(scoreCard1);
            scoreCardRepository.save(scoreCard2);
            scoreCardRepository.save(scoreCard3);
            scoreCardRepository.save(scoreCard4);
        }
    }
}
