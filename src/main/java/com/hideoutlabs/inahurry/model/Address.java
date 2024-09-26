package com.hideoutlabs.inahurry.model;

import java.io.Serializable;


public abstract class Address  implements Serializable {

    private MapLocation l1;
    private final String address;


    public Address(String address){
        this.address = address;


    }



}
