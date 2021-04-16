package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerService2Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerService2Application.class, args);
    }
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();

    }



}
