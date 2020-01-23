package org.micronaut.service;

import org.micronaut.domain.Trivia;
import org.micronaut.domain.User;
import org.micronaut.repository.TriviaRepository;
import org.micronaut.repository.UserRepository;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Singleton
public class TriviaServiceImpl implements TriviaService {

    private TriviaRepository triviaRepository;

    private UserRepository userRepository;

    public TriviaServiceImpl(TriviaRepository triviaRepository, UserRepository userRepository) {
        this.triviaRepository = triviaRepository;
        this.userRepository = userRepository;
    }

    // generate random questions, capture previous state
    @Override
    public Trivia getTrivia() {
        List<Trivia> triviaList = triviaRepository.findAll();
        return triviaList.get(new Random().nextInt(triviaList.size()));
    }

    @Override
    public User checkUser(User user) {

        /*Check if the user exists in the database by name, if exists, persist response to existing user*/
        Optional<User> userCheck = userRepository.findByName(user.getName());
        User user1 = userCheck.isEmpty() ? userRepository.save(user) : userCheck.get();

        return user1;
    }
}
