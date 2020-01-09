package org.micronaut;


import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import org.micronaut.domain.Trivia;
import org.micronaut.repository.TriviaRepository;

import javax.inject.Singleton;

@Singleton
@Requires(notEnv = Environment.TEST)
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    private TriviaRepository repository;

    public DataLoader(TriviaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        if (repository.count() == 0) {
            Trivia trivia1 = new Trivia("Who is the president of the USA",
                    "Obama|Trump|Lincon", 1);

            Trivia trivia2 = new Trivia("What's the real name of Spiderman",
                    "Peter Parker|Peter Pan|John Stark", 2);

            Trivia trivia3 = new Trivia("What's the real name of Batman",
                    "Bruce Wayne|Bruce Lee|Bane Bruce", 1);

            Trivia trivia4 = new Trivia("Who is the founder of Apple Inc?",
                    "Steve Jobs|Steven Gerrard|Steel Jobs", 1);

            Trivia trivia5 = new Trivia("Who is the founder of Microsoft?",
                    "Bill Gatsby | Ben Gates | Bill Gates", 3);

            Trivia trivia6 = new Trivia("What is the real name of Superman?",
                    "Kent Clair | Kennedy Clerk | Clark Kent", 3);



            repository.save(trivia1);
            repository.save(trivia2);
        }
    }
}
