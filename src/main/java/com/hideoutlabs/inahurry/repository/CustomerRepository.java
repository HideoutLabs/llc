package com.hideoutlabs.inahurry.repository;


import com.hideoutlabs.inahurry.model.Customer;
import com.hideoutlabs.inahurry.model.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{


    @Override
    void deleteById(Long aLong);

    @Override
    public List<Customer> findAll();




}
