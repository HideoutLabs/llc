package com.hideoutlabs.inahurry.controller;


import com.hideoutlabs.inahurry.service.LocationsService;
import com.hideoutlabs.inahurry.service.UserService;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("main-stage.fxml")
public class MyController {

    @FXML
    private Label weatherLabel;


 //   private LocationsService locationService;





}
