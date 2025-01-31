package com.example.service;

import com.example.entity.Employee;
import com.example.model.AddressResponse;
import com.example.model.EmployeeResponse;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public  class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    WebClient webClient;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    private static int count = 0;


    public EmployeeResponse getEmployee(int id){
        System.out.println("Request Count "+ (++count));
        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(employee, employeeResponse);


        //AddressResponse addressResponse = getAddressUsingRestTemplate(id);
        AddressResponse addressResponse = getAddressUsingDiscoveryClient(id);
        //System.out.println("ADDRESSRESPONSE"+ addressResponse);
        employeeResponse.setAddressResponse(addressResponse);

        String res = publicfinal();
        System.out.println("publicfinal response "+ res);
        return employeeResponse;
    }

    private AddressResponse getAddressUsingDiscoveryClient(int id){

        //Service Discovery using DiscoveryClient
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("address-service");
//        ServiceInstance serviceInstance = serviceInstances.get(0);
//        String uri = serviceInstance.getUri().toString();

        // Service Discovery using LoadBalancerClient
//        ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
//        System.out.println(serviceInstance.getMetadata());
//        String uri = serviceInstance.getUri().toString();
//        String contextPath = serviceInstance.getMetadata().get("contextPath");

        // service discovery using @LoadBalanced
        String uri = "http://address-service";
        String contextPath = "/address-app/api";
        System.out.println("URI >>>>> "+uri);


        return restTemplate.getForObject(uri+   contextPath + "/address/{empID}", AddressResponse.class, id);

//        return   webClient.get()
//                .uri(uri+   contextPath + "/address/"+id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .doOnNext( content -> System.out.println("1. isInNonBlockingThread : "+Schedulers.isInNonBlockingThread()))
//                .publishOn(Schedulers.boundedElastic())
//                .doOnNext( content -> System.out.println("2. isInNonBlockingThread : "+Schedulers.isInNonBlockingThread()))
//                 .block();
    }

//    private AddressResponse getAddressUsingWebClient(int id) {
//
//        return   webClient.get()
//                .uri("/address/"+id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .doOnNext( content -> System.out.println("1. isInNonBlockingThread : "+Schedulers.isInNonBlockingThread()))
//                .publishOn(Schedulers.boundedElastic())
//                .doOnNext( content -> System.out.println("2. isInNonBlockingThread : "+Schedulers.isInNonBlockingThread()))
//                 .block();
//    }

//    private AddressResponse getAddressUsingRestTemplate(int id) {
//        return restTemplate.getForObject("/address/{empID}", AddressResponse.class, id);
//    }

    final public String  publicfinal(){
        System.out.println("public final method");
        return "Hello";
    }
}
