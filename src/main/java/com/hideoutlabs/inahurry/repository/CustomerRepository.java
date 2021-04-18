package com.hideoutlabs.inahurry.repository;


import com.hideoutlabs.inahurry.model.Customer;

import com.hideoutlabs.inahurry.model.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{


    @Override
    Optional<Customer> findById(Long aLong);

    @Query("SELECT u FROM Customer u WHERE u.cusEmail = :email")
    Optional<Customer> findUserByEmail(@Param("email") String email);

    @Override
    void deleteById(Long aLong);

    @Override
    public List<Customer> findAll();


}
