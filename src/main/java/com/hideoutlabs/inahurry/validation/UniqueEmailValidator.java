package com.hideoutlabs.inahurry.validation;

import com.hideoutlabs.inahurry.model.Customer;
import com.hideoutlabs.inahurry.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Optional<Customer> customer= customerRepository.findUserByEmail(email);

      return  customer.isPresent();
    }
}
