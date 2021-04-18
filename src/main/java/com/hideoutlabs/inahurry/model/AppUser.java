package com.hideoutlabs.inahurry.model;

import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppUser {


    protected Long pid;

    protected List<Address> homeAddress= new ArrayList<>();
    protected LocalDateTime dateofRegistration;
    protected String IPAddress;


    public AppUser(){

    }

   public AppUser(String ip,  MapLocation initMapLocation) {
        initMapLocation = new MapLocation();
        this.IPAddress =ip;




        try {
            InetAddress ipp = InetAddress.getByName(ip);
            CountryResponse countryResponse = initMapLocation.country(ipp);
            CityResponse cityResponse = initMapLocation.city(ipp);

        } catch(Exception e){
            System.out.println(e);
        }
   }



}
