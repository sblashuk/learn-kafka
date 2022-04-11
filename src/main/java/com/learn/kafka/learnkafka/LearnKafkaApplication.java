package com.learn.kafka.learnkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@EnableScheduling
@EnableConfigurationProperties
@SpringBootApplication
public class LearnKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnKafkaApplication.class, args);
    }

}
