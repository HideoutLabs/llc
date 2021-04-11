package com.hideoutlabs.inahurry.service;

import com.hideoutlabs.inahurry.model.Customer;
import com.hideoutlabs.inahurry.model.Users;
import com.hideoutlabs.inahurry.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
