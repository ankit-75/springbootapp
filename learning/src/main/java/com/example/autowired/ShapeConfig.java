package com.example.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShapeConfig {
    @Bean
    Square square(){
        return new Square();
    }

    @Bean
    Circle circle(){
        return new Circle();
    }
}

interface Shape{
    void name();
}

class Circle implements Shape{

    public Circle() {
        System.out.println("********* Circle constructor");
    }

    @Override
    public void name() {
        System.out.println("********* Circle name method");
    }
}

class Square implements Shape{

    public Square() {
        System.out.println("********* Square");
    }

    @Override
    public void name() {
        System.out.println("********* Square name method");
    }
}