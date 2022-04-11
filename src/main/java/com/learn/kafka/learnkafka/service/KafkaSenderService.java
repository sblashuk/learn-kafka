package com.learn.kafka.learnkafka.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@Profile("producer")
public class KafkaSenderService {

    private KafkaProducerService producerService;
    private MessageService messageService;

    @Scheduled(fixedRate = 1000)
    public void scheduleSendingMessages() throws IOException {
        producerService.sendMessage(messageService.generateHelloMessage());
    }
}
