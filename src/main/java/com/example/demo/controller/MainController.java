package com.example.demo.controller;


import com.amazonaws.util.EC2MetadataUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController()
@RequestMapping("/api/v1")
public class MainController {
    @GetMapping(value = "/user", produces = "application/json")
    public HashMap<String, String> getIndex(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", "Ankit");
        hashMap.put("address", "LKO");
        hashMap.put("city", "LKO");
        return hashMap;
    }

    @GetMapping(value = "/region", produces = "application/json")
    public HashMap<String, String> getRegion(){
        HashMap<String, String> hashMap = new HashMap<>();

        EC2MetadataUtils.InstanceInfo instanceInfo =
                EC2MetadataUtils.getInstanceInfo();


        if(instanceInfo == null){
            hashMap.put("error", "Instance info not available");
            return hashMap;
        }

        String region = instanceInfo.getRegion();
        hashMap.put("region", region);
        return hashMap;
    }



}
