package com.example.demo.controller;

import com.example.demo.services.KafkaMessegeProducer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KafkaMessegeController {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessegeController.class);
    @Autowired
    private KafkaMessegeProducer producer;

    @PostMapping("/send")
   public String getMessage(@RequestParam(name = "msg") String messege) throws Exception {
       producer.sendMessage("my-topic", messege);
        log.info("asdf");
       return "messege sent "+messege;
    }

}
