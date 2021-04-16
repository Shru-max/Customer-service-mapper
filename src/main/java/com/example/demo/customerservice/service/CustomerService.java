package com.example.demo.customerservice.service;

import com.example.demo.customerservice.model.CustomerModel;
import com.example.demo.customerservice.shared.CustomerRequestModel;
import com.example.demo.customerservice.shared.CustomerResponseModel;

import java.util.List;

public interface CustomerService {
    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails);
    List<CustomerModel> getAllAccount();
}
