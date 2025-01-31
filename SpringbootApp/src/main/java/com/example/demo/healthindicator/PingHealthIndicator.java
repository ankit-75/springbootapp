package com.example.demo.healthindicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Component;

@Component
public class PingHealthIndicator extends AbstractHealthIndicator {

//    @Autowired
//    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up();
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        return super.getHealth(includeDetails);
    }
}
