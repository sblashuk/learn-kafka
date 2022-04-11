package com.learn.kafka.learnkafka.service;

import com.learn.kafka.learnkafka.configuration.properties.KafkaProperties;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Profile("producer")
@AllArgsConstructor
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private KafkaProperties properties;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("Producing message: [%s]", message));
        this.kafkaTemplate.send(properties.getTopic(), message);
    }
}
