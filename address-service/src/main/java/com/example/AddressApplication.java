package com.example;

import com.example.entity.Address;
import com.example.repository.AddressRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class AddressApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(AddressApplication.class);

    }

    //@Bean
    ApplicationRunner runner(AddressRepository repository){
        return (args) -> {
            Address address = new Address();
            address.setLane1("lane1");
            address.setLane2("lane2");
            address.setZip(247776);
            address.setEmployeeId(1);
            repository.save(address);

        };
    }
}
