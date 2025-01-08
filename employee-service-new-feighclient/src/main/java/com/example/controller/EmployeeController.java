package com.example.controller;

import com.example.model.EmployeeResponse;
import com.example.service.EmployeeService;
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
}
