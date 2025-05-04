package org.wenzhuo4657.test.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class query {



    @Autowired
    private Environment environment;
    @GetMapping(value = "/api")
    public  String query(@RequestParam("id") String id){
       return environment.getProperty(id);
    }

}
