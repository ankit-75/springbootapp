package com.example;

import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */


@SpringBootApplication(scanBasePackages = "com.example.singletonPrototypeScope",
        exclude = {SecurityAutoConfiguration.class })
public class LearningApp
{

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LearningApp.class, args);
        System.out.println(run);

//        ArrayList<String> arr = null;
//        System.out.println("**for loop start**");
//        for(String s : arr){
//            System.out.println(s);
//        }
    }

   // @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Ankit Kumar", "ankit", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Sandhya Singh", "sandhya", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "jim", "jim", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Arnold", "arnold", "12345", new ArrayList<>()));

            userService.addRoleToUser("ankit", "ROLE_USER");
            userService.addRoleToUser("sandhya", "ROLE_MANAGER");
            userService.addRoleToUser("jim", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_USER");
            userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
        };

    }

}
