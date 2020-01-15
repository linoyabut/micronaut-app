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

            Trivia trivia1 = new Trivia("Who is the president of the USA?",
                    "Obama|Trump|Lincon", 1);

            Trivia trivia2 = new Trivia("What's the real name of Spiderman?",
                    "Peter Parker|Peter Pan|John Stark", 0);

            Trivia trivia3 = new Trivia("What's the real name of Batman?",
                    "Bruce Wayne|Bruce Lee|Bane Bruce", 0);

            Trivia trivia4 = new Trivia("Who is the founder of Apple Inc?",
                    "Steve Jobs|Steven Gerrard|Steel Jobs", 0);

            Trivia trivia5 = new Trivia("Who is the founder of Microsoft?",
                    "Bill Gatsby|Ben Gates|Bill Gates", 2);

            Trivia trivia6 = new Trivia("What is the real name of Superman?",
                    "Kent Clair|Kennedy Clerk|Clark Kent", 2);

            Trivia trivia7 = new Trivia("What is 40 + 50?",
                    "90|100|300", 0);

            Trivia trivia8 = new Trivia("What is 100 + 50?",
                    "110|150|50", 1);

            Trivia trivia9 = new Trivia("What is 100 multiplied by 3?",
                    "400|300|200", 1);



            repository.save(trivia1);
            repository.save(trivia2);
            repository.save(trivia3);
            repository.save(trivia4);
            repository.save(trivia5);
            repository.save(trivia6);
        }
    }
}
