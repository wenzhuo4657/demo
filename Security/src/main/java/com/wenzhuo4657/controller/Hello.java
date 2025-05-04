package com.wenzhuo4657.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {



    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('system:dept:lis')")
    public String hello(){
        return "hello";
    }
}
