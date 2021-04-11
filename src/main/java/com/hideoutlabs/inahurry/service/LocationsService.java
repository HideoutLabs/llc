package com.hideoutlabs.inahurry.service;


import com.hideoutlabs.inahurry.domain.GenericService;
import com.hideoutlabs.inahurry.model.Users;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface LocationsService extends GenericService<Users> {

    public abstract String getLocationServiceDetails(String ip) throws IOException, GeoIp2Exception;

}
