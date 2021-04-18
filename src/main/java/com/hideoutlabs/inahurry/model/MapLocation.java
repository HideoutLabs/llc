package com.hideoutlabs.inahurry.model;

import com.maxmind.geoip2.GeoIp2Provider;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Postal;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.IOException;
import java.net.InetAddress;


public class MapLocation implements GeoIp2Provider {



    private CountryResponse countryResponse;
    private CityResponse cityResponse;

    public MapLocation(){

  }



    public City getCity() {
        return cityResponse.getCity();
    }



    public Postal getPostalCode() {
        return cityResponse.getPostal();
    }



    public Country getCountryCode() {
        return countryResponse.getRegisteredCountry();
    }



    public Country getCountryName() {
        return countryResponse.getCountry();
    }



    public Double getLatitude() {
        return cityResponse.getLocation().getLatitude();
    }



    public Double getLongitude() {
        return cityResponse.getLocation().getLongitude();
    }



    @Override
    public CountryResponse country(InetAddress ipAddress) throws IOException, GeoIp2Exception {
       return countryResponse;
    }

    @Override
    public CityResponse city(InetAddress ipAddress) throws IOException, GeoIp2Exception {
       return cityResponse;
    }
}
