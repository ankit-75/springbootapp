package com.example.service;

import com.example.entity.Employee;
import com.example.model.AddressResponse;
import com.example.model.EmployeeResponse;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Spy
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void getEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        //doReturn(new AddressResponse()).when(restTemplate).getForObject(anyString(), any(AddressResponse.class));
        when(restTemplate.getForObject(anyString(), eq(AddressResponse.class), anyInt() )) .thenReturn(new AddressResponse());
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(employee));

        when(employeeService.publicfinal()).thenReturn("Ankit");

        EmployeeResponse employeeResponse =  employeeService.getEmployee(anyInt());
        Mockito.verify(employeeRepository, times(1)).findById(anyInt());

        assertEquals(1, employeeResponse.getId());
    }


}