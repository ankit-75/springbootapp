package com.example.service;

import com.example.entity.Employee;
import com.example.feignclient.AddressClient;
import com.example.logger.ThreadLogger;
import com.example.model.AddressResponse;
import com.example.model.EmployeeResponse;
import com.example.repository.EmployeeRepository;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    AddressClient addressClient;


    private static int count = 0;


    public EmployeeResponse getEmployee(int id){
        System.out.println("Request Count "+ (++count));
        ThreadLogger.log("getEmployee");
        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(employee, employeeResponse);



        AddressResponse addressResponse = addressClient.getAddressByEmployeeId(id); //getAddressUsingWebClient(id);
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }


}
