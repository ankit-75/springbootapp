package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController()
public class CompanyController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping(value = "/company", produces = "application/json")
    public ResponseEntity<List<Employee>> getIndex(){
        List<Employee> list = employeeRepository.findByCompanyNameIsLike("EPAM6%");
        System.out.println(list);
        return ResponseEntity.ok(list);
    }


    @GetMapping(value = "/company/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable(name = "id") Integer empid ){
        Employee emp = employeeRepository.findById(empid).orElseThrow( () -> new ResourceNotFound("Emp not found with id "+ empid));
        System.out.println(emp);
        return new ResponseEntity(emp, HttpStatus.OK);
    }

}
