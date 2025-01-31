package com.example.demo.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaMessegeConsumer {

    @KafkaListener(topics = {"my-topic", "kafka-health-indicator"}, groupId = "group-id")
    public void listen(ConsumerRecord<String, String> message, @Headers Map<String, Object> heders, Acknowledgment ack){
        System.out.println("Headers "+heders);
//        System.out.println("Received messege topic"+message.topic());
//        System.out.println("Received messege value"+message.value());
        System.out.println("Received messege "+message);
        System.out.println("ACK "+ ack);
       ack.acknowledge();

    }
}
