//package com.example;
//
//import com.example.singletonPrototypeScope.UserService;
//import com.example.singletonPrototypeScope.WeatherService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
///**
// * Unit test for simple App.
// */
//@SpringBootTest
//public class AppTest
//{
//    @Autowired
//    ApplicationContext context;
//
//
//    @Test
//    public void singleTonScopeTest(){
//       UserService userService1 =  context.getBean(UserService.class);
//       UserService userService2 =  context.getBean(UserService.class);
//       assertEquals(userService1.hashCode(), userService2.hashCode());
//    }
//
//    @Test
//    public void protypeScopeTest(){
//        WeatherService weatherService1 = context.getBean(WeatherService.class);
//        WeatherService weatherService2 = context.getBean(WeatherService.class);
//        assertNotEquals(weatherService1.hashCode(), weatherService2.hashCode());
//    }
//
//
//}
//
//
