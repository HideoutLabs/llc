package com.hideoutlabs.inahurry.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Person {


    protected Long pid;
    protected Location initLocation;
    protected List<Address> homeAddress= new ArrayList<>();
    protected LocalDateTime dateofRegistration;
}
