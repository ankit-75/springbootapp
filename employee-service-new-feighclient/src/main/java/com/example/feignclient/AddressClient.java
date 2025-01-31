package com.example.feignclient;

import com.example.model.AddressResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8082/address-app/api/address/2
@FeignClient(name = "address-feignClient", url="http://localhost:8082", path = "/address-app/api")
// Need to implement Load balancer because url may be many (Use ribbon to implement LB)
public interface AddressClient {

    @GetMapping("/address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
}
