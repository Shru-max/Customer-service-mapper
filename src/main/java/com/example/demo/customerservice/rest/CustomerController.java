package com.example.demo.customerservice.rest;

import com.example.demo.customerservice.service.CustomerService;
import com.example.demo.customerservice.shared.CustomerRequestModel;
import com.example.demo.customerservice.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;
@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseModel> createCustomer(@RequestBody CustomerRequestModel customerRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequestModel));

    }

    @GetMapping("/display")
    public List<CustomerResponseModel> getalldata() {
        ModelMapper mapper = new ModelMapper();
        return customerService.getAllAccount().stream().map(post -> mapper.map(post,CustomerResponseModel.class)).collect(Collectors.toList());
    }
}
