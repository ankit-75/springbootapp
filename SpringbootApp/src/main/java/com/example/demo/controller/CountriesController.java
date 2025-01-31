package com.example.demo.controller;

import com.example.demo.services.ContriesService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountriesController {

    @Autowired
    private ContriesService contriesService;

    @GetMapping("/country")
    @CircuitBreaker(name = "countryCuicuitBreaker", fallbackMethod = "getCountries")
    public List<Object> getCountries() throws Exception {
        return contriesService.getConntry();
    }

    public List<Object> getCountries(Throwable ex){
        List<Object> list = new ArrayList<>();
        list.add("country service unavailable");
        return list;
    }


    @GetMapping("/retry")
    @Retry(name = "retrycountry", fallbackMethod = "getRetryCountries")
    public List<Object> getRetryCountries() throws Exception {
        return contriesService.getConntry();
    }

    public List<Object> getRetryCountries(Throwable ex){
        List<Object> list = new ArrayList<>();
        list.add("all retry exhausted");
        return list;
    }


}
