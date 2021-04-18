package com.hideoutlabs.inahurry.controller;


import com.hideoutlabs.inahurry.model.Customer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/customers")
public class CustomerManagementController {

    private static final List<Customer> CUSTOMERS = Arrays.asList(
            new Customer(1L,"James","Bond","192.168.0.12","cus1@mac.com"),
            new Customer(2L,"Maria","Jones","192.168.0.13","cus2@mac.com"),
            new Customer(3L,"Anna", "Smith","192.168.0.14","cus3@mac.com")

    );


   @GetMapping
  // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_REPORT')")
    public List<Customer> getAllCustomers(){
       System.out.println("getAllCustomers");

        return CUSTOMERS;
    }

    @GetMapping(path="{customerId}")
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_REPORT')")
    public Customer getCustomers(@PathVariable("customerId") Long custID){
        System.out.println("getACustomers");
        return CUSTOMERS.stream().filter(customer->custID.equals(customer.getCusId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Customer"+custID+"does not exist"));

    }

    @PostMapping
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_REPORT')")
    public void registerNewCustomer(@RequestBody Customer cust){
        System.out.println("registerNewCustomer");
        System.out.println(cust);
    }

    @DeleteMapping(path="{customerId}")
   // @PreAuthorize("hasAuthority('customer:write')")
    public void deleteCustomer(@PathVariable("customerId") Long custID){
        System.out.println("DeleteCustomer");
        System.out.println(custID);
    }

    @PutMapping(path="{customerId}")
   // @PreAuthorize("hasAuthority('customer:write')")
    public void updateCustomer(@PathVariable("customerId") Long custId,@RequestBody Customer cust){
        System.out.println("updateCustomer");
       System.out.println(String.format("%s %s",custId,cust));
    }





}
