package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ContriesService {

    private final RestTemplate restTemplate;

    public ContriesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Object> getConntry() throws Exception {
        Object []countries ;
        try{
            countries =  restTemplate.getForObject("https://restcountries.com/v3.1/all", Object[].class);

        }
        catch (Exception e){
            throw new Exception("failed to fetch contries");
        }
        return Arrays.stream(countries).toList().subList(0,10);
        }
}
