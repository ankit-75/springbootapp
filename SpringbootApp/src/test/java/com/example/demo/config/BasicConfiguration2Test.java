package com.example.demo.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicConfiguration2Test {
    TestRestTemplate testRestTemplate;
    URL url;


    @LocalServerPort
    int port;

    @BeforeEach
    public void  setup() throws MalformedURLException {
        testRestTemplate = new TestRestTemplate("user", "12345");
        url = new URL("http://localhost:"+port+"/api/v1/user");
    }


    @Test
    public void userDetailsManager() {
        ResponseEntity<String> response =  testRestTemplate.getForEntity(url.toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}