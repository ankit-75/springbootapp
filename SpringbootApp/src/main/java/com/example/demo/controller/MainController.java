package com.example.demo.controller;


import com.amazonaws.util.EC2MetadataUtils;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@RestController()
@RequestMapping("/api/v1")
public class MainController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/user", produces = "application/json")
    public HashMap<String, String> getIndex(){
       
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", "Ankit");
        hashMap.put("address", "LKO");
        hashMap.put("city", "LKO");
        return hashMap;
    }

    @GetMapping(value = {"/user1", "/user1/{id}"}, produces = "application/json")
    public HashMap<String, String> pathVar(@PathVariable(value = "id", required = false) String id2, @RequestParam(name = "name", required = false) String name) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id2);
        hashMap.put("name", name);
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
