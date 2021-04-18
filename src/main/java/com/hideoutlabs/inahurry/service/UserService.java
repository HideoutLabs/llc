package com.hideoutlabs.inahurry.service;

import com.hideoutlabs.inahurry.model.Users;
import com.hideoutlabs.inahurry.domain.GenericService;
import com.hideoutlabs.inahurry.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends GenericService<Users>  {

    boolean authenticate(String email, String password);

    Users findByEmail(String email);



}