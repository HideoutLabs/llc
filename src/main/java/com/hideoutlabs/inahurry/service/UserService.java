package com.hideoutlabs.inahurry.service;

import com.hideoutlabs.inahurry.model.Users;
import com.hideoutlabs.inahurry.domain.GenericService;
import com.hideoutlabs.inahurry.model.Users;

public interface UserService extends GenericService<Users> {

    boolean authenticate(String email, String password);

    Users findByEmail(String email);

}