package com.example.demo.service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.CustomerModel;

import com.example.demo.shared.CustomerRequestModel;
import com.example.demo.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private ModelMapper modelMapper;
    private CustomerRepository customerRepository;
@Autowired
    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=modelMapper.map(customerDetails,CustomerModel.class);
        model.setCustomerId(UUID.randomUUID().toString());
        CustomerModel response=customerRepository.save(model);
        return modelMapper.map(response,CustomerResponseModel.class);
    }

    @Override
    public List<CustomerModel> getAllAccount() {
        return customerRepository.findAll();
    }
}
