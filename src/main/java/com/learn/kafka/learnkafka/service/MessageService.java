package com.learn.kafka.learnkafka.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Profile("producer")
@AllArgsConstructor
public class MessageService {

    private static final String[] NAMES = {"Siarhei", "World", "Bob", "James", "John", "Robert"};

    private final Random rnd = new Random();

    public String generateHelloMessage() {
        return String.format("Hello %s!", NAMES[rnd.nextInt(NAMES.length)]);
    }
}
