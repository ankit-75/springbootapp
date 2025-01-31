package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeConfig {

    @Value("${addressservice.base.url}")
    private String baseUrl;


//    @Bean
//    public WebClient webClient(){
//        return
//                WebClient.builder()
//                        //.baseUrl(baseUrl)
//                        .build();
//    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
