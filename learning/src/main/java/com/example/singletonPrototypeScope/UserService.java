package com.example.singletonPrototypeScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserService {
    public UserService() {
        System.out.println("########### UserService constructor");
    }

    @PostConstruct
    void init(){
        System.out.println("########### UserService init");
    }

    @PreDestroy
    void destroy(){
        System.out.println("########### UserService destroy");
    }


    // Issue with prototype bean
//    @Autowired
//    WeatherService weatherService;
//
//    public String getCurrentTime() {
//        return  weatherService.getTime();
//    }


    // First approach using application context - Not recomended

//    @Autowired
//    ApplicationContext context;
//
//    public String getCurrentTime() {
//         return  context.getBean(WeatherService.class).getTime();
//    }


    // Using object factory
//    @Autowired
//    ObjectFactory<WeatherService> weatherObject;
//
//    public String getCurrentTime() {
//         return weatherObject.getObject().getTime();
//    }




    // Using @lookup
    public String getCurrentTime() {
        return getWeatherBean().getTime();
    }

    @Lookup    // spring uses CGLIB to dynamically override this method to provide its implementation
    public WeatherService getWeatherBean(){
        return  null;
    }
}
