package com.hideoutlabs.inahurry.service.impl;

import java.util.List;

import com.hideoutlabs.inahurry.exceptions.CustomException;
import com.hideoutlabs.inahurry.exceptions.CustomExceptionImpl;
import com.hideoutlabs.inahurry.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hideoutlabs.inahurry.model.Users;
import com.hideoutlabs.inahurry.repository.UserRepository;
import com.hideoutlabs.inahurry.service.UserService;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users save(Users entity) {
        return userRepository.save(entity);
    }

    @Override
    public Users update(Users entity) {
        return userRepository.save(entity);
    }

    @Override
    public void delete(Users entity) {
        userRepository.delete(entity);
    }

    public void delete(Long id) {

    }



    public Users find(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with userId " + id));

    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean authenticate(String username, String password){
        Users user = this.findByEmail(username);
        if(user == null){
            return false;
        }else{
            if(password.equals(user.getPassword())) return true;
            else return false;
        }
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void deleteInBatch(List<Users> users) {
        userRepository.deleteInBatch(users);
    }

}