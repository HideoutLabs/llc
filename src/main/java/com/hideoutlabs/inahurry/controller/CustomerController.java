package com.hideoutlabs.inahurry.controller;

import com.hideoutlabs.inahurry.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

   private static final List<Customer> CUSTOMER = Arrays.asList(
           new Customer(1L,"James","Bond","192.168.0.12","cus1@mac.com"),
           new Customer(2L,"Maria","Jones","192.168.0.13","cus2@mac.com"),
          new Customer(3L,"Anna", "Smith","192.168.0.14","cus3@mac.com")
   );




    @GetMapping(path ="{cusId}")
    public Customer  getCustomer(@PathVariable("cusId") Long cusId){
        return CUSTOMER.stream().filter(customer->cusId.equals(customer.getCusId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Customer"+cusId+"does not exist"));
    }




}

