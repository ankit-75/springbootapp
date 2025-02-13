//// junit 4 test
//
//
//package com.example.demo.config;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import static org.junit.Assert.assertEquals;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class BasicConfigurationTest {
//    TestRestTemplate testRestTemplate;
//    URL url;
//
//
//    @LocalServerPort
//    int port;
//
//    @Before
//    public void  setup() throws MalformedURLException {
//        testRestTemplate = new TestRestTemplate("user", "12345");
//        url = new URL("http://localhost:"+port+"/api/v1/user");
//    }
//
//
//    @Test
//    public void userDetailsManager() {
//        ResponseEntity<String> response =  testRestTemplate.getForEntity(url.toString(), String.class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//}