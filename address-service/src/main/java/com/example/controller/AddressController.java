package com.example.controller;

import com.example.model.AddressResponse;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/address/{empId}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("empId") int id){
        AddressResponse employeeResponse = addressService.getAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }
}
