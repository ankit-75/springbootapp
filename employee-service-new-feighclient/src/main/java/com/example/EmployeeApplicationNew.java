package com.example;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@EnableFeignClients
@SpringBootApplication
public class EmployeeApplicationNew
{
    public static void main(String[] args) {

        SpringApplication.run(EmployeeApplicationNew.class, args);
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
