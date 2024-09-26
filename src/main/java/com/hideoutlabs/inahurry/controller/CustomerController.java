package com.hideoutlabs.inahurry.controller;

import com.hideoutlabs.inahurry.exceptions.CustomException;
import com.hideoutlabs.inahurry.model.Customer;
import com.hideoutlabs.inahurry.service.CustomerService;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController  {


   @Autowired
  private  CustomerService customerService;

 

    @GetMapping(path ="{cusId}")
 @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    public Optional<Customer> getCustomer(@PathVariable("cusId") Long cusId){
          return  customerService.findByID(cusId);

                //.stream().filter(customer->cusId.equals(customer.getCusId()))
               // .findFirst()
                //.orElseThrow(()->new IllegalStateException("Customer"+cusId+"does not exist"));
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    public ResponseEntity<Customer> newCustomer(@Valid @RequestBody List<Customer> cus) {

         customerService.saveCustomer(cus);
        return new ResponseEntity<Customer>(HttpStatus.CREATED);
    }





}

