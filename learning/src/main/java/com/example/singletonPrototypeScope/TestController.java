package com.example.singletonPrototypeScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    UserService userService;


    @GetMapping(value = "time", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> get() throws InterruptedException {
        String time1 = userService.getCurrentTime();
        Thread.sleep(1000);
        String time2 = userService.getCurrentTime();

        return Arrays.asList(time1, time2);
    }
}
