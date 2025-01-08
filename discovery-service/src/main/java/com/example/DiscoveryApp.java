package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.annotation.Order;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer

public class DiscoveryApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(DiscoveryApp.class);
        System.out.println( "Hello World!" );
    }
}
