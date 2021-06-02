package com.niranjan2021.configclient.controller;


import com.niranjan2021.configclient.LoadConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.DefaultValue;

@RestController
@Configuration
@RefreshScope
public class HomeController {

    @Autowired
    private LoadConfigProperties loadConfigProperties;


    @Value("${some.other.property}")
    private String someOtherProperty;

    @Value("${name:king}")
    private  String name;

    @GetMapping
    public  String getConfigPropertiesFromConfigServer(){

        StringBuilder response = new StringBuilder();
        response.append(someOtherProperty);
        response.append("||");
        response.append(loadConfigProperties.getProperty());
        return response.toString();
    }



    @GetMapping("/testpropertiesload")
    public  String getPropertiesFromApp(){

        return name;
    }

}
