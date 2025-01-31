package com.example.controller;

import com.example.model.EmployeeResponse;
import com.example.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") int id){
        EmployeeResponse employeeResponse = employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }



    @PostConstruct
    public void init1(){
        System.out.println("Test init1 method");
    }

    @PostConstruct
    public void init2(){
        System.out.println("Test init2 method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Test destroy method");
    }
}
