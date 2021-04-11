package com.hideoutlabs.inahurry.service.impl;


import com.hideoutlabs.inahurry.exceptions.ResourceNotFoundException;
import com.hideoutlabs.inahurry.model.Location;
import com.hideoutlabs.inahurry.model.Users;
import com.hideoutlabs.inahurry.service.LocationsService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class LocationServiceImpl implements LocationsService {



   public String getLocationServiceDetails(String ip)  throws IOException, GeoIp2Exception {


        String dbLocation = "./GeoLite2-City.mmdb";

        File database = new File(dbLocation);
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String countryName = response.getCountry().getName();
        String cityName = response.getCity().getName();
        String postal = response.getPostal().getCode();
        String countryCode = response.getCountry().getIsoCode();
        String state = response.getLeastSpecificSubdivision().getName();
        Double latitude = response.getLocation().getLatitude();
        Double longitude = response.getLocation().getLongitude();

        return "LA Success";
                //new Location(cityName,postal,countryCode,countryName,latitude,longitude);

    }

     @Override
     public Users save(Users entity) {
          return null;
     }

     @Override
     public Users update(Users entity) {
          return null;
     }

     @Override
     public void delete(Users entity) {

     }

     @Override
     public void delete(Long id) {

     }

     @Override
     public void deleteInBatch(List<Users> entities) {

     }

     @Override
     public Users find(Long id) throws ResourceNotFoundException {
          return null;
     }

     @Override
     public List<Users> findAll() {
          return null;
     }
}
