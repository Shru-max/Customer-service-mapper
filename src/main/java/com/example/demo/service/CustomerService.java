package com.example.demo.service;

import com.example.demo.model.CustomerModel;
import com.example.demo.shared.CustomerRequestModel;
import com.example.demo.shared.CustomerResponseModel;


import java.util.List;

public interface CustomerService {
    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails);
    List<CustomerModel> getAllAccount();
}
