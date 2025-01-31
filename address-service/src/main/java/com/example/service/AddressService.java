package com.example.service;

import com.example.entity.Address;
import com.example.model.AddressResponse;
import com.example.repository.AddressRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private static int count = 0;
    @Autowired
    AddressRepository addressRepository;

    public AddressResponse getAddress(int id){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Request count "+ ++count);
        Address employee = addressRepository.findByEmployeeId(id);
        AddressResponse employeeResponse = new AddressResponse();
        BeanUtils.copyProperties(employee, employeeResponse);
        return employeeResponse;
    }
}
