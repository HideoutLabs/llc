package com.hideoutlabs.inahurry.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


public class Location {


    private String city;
    private String postalCode;
    private String countryCode;
    private String countryName;
    private Double latitude;
    private Double longitude;


    public Location( String city, String postalCode, String countryCode, String countryName, Double latitude, Double longitude) {

        this.city = city;
        this.postalCode = postalCode;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

   Location(){

   }

}
