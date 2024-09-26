package com.hideoutlabs.inahurry.controller;


import com.hideoutlabs.inahurry.model.MapLocation;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/location")
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="This customer is not found in the Geo system")
public class LocationController {
    @GetMapping
    public ResponseEntity<MapLocation> searchLocation(@RequestParam @Valid @NotEmpty LocationCritiria locationCriteria) throws IOException, GeoIp2Exception {

      //  List <Location> locationList = new ArrayList<Location>();
    // return  LocationService(cityName,postal,countryCode,countryName,latitude,longitude);



//        LocationService locationServ ;
//
//
//        locationCriteria(locationServ.getLocationServiceDetails());

        if(!locationCriteria.equals(null)){

        }

        return null;

    }

}
