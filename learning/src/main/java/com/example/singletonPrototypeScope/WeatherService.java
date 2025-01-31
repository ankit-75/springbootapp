package com.example.singletonPrototypeScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@Scope("prototype")
@Setter
public class WeatherService {
    String time = LocalDateTime.now().toString();
    int temp = new Random().nextInt(60);

    public WeatherService() {
        System.out.println("########### WeatherService constructor");
    }

    public String getTime(){
        return time + "-"+temp;
    }

    @PostConstruct
    void init(){
        System.out.println("########### WeatherService init");
    }

    @PreDestroy
    void destroy(){
        System.out.println("########### WeatherService destroy");
    }
}
