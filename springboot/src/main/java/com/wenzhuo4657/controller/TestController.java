package com.wenzhuo4657.controller;


import com.wenzhuo4657.config.TestConfig;
import com.wenzhuo4657.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestConfig testConfig;

    User user;
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(@RequestBody User user){
        User name = testConfig.getName();
        return "test";
    }

}
