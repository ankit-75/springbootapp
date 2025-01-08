package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeApplication
{
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(EmployeeApplication.class, args);
        System.out.println(run);

        System.out.println(11>>1);

        Arrays.asList(1);
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            String el = itr.next();
            //list.add("D");
            if(el.equals("C"))
              itr.remove();
        }
        Integer in = 5;

        //  NoOpPasswordEncoder - singleton design pattern
        //
       // SessionFactory - factory classes
        //BeanFactory

        System.out.println(list);
    }

   // @Bean
    ApplicationRunner run(EmployeeRepository repository){
        return (args)-> {
            Employee employee = new Employee();
            employee.setName("Ankit");
            employee.setBloodGroup("B+");
            repository.save(employee);
        };
    }
}
