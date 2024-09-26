package com.hideoutlabs.inahurry.service;


import com.hideoutlabs.inahurry.domain.GenericService;
import com.hideoutlabs.inahurry.exceptions.ResourceNotFoundException;
import com.hideoutlabs.inahurry.model.Customer;
import com.hideoutlabs.inahurry.model.Users;
import com.hideoutlabs.inahurry.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface CustomerService extends GenericService<Customer> {

   public Customer find(Long id) throws ResourceNotFoundException ;

    public Optional<Customer> findByID(Long id);

    public Customer save(Customer entity) ;


    public List<Customer> findAll();


 public List<Customer> saveCustomer(List<Customer> customers);






}

