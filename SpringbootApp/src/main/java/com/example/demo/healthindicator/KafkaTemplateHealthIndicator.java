package com.example.demo.healthindicator;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@ConditionalOnEnabledHealthIndicator("kafka-template")
public class KafkaTemplateHealthIndicator implements HealthIndicator {
    private static final Logger log = LoggerFactory.getLogger(KafkaTemplateHealthIndicator.class);
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private int timeout = 100;

    @PostConstruct
    void postConstruct(){
        log.info("[KafkaHealthIndicator] timeout 100ms");
    }


    @Override
    public Health health() {
        try {
            kafkaTemplate.send("kafka-health-indicator", "PING").get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException | NullPointerException e) {
            log.error("[kafka-health-indicator]: Kafka Health Down! Caught cause: {}", e);
            return Health.down(e). build();
        }
        return Health.up().build();
    }
}
