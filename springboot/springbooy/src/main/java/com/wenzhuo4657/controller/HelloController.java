package com.wenzhuo4657.controller;

import com.wenzhuo4657.domain.stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


        @Value("${name}")
        private String lastName;
        @RequestMapping("/test")
        public String test(){
            System.out.println(lastName);
            return "hi";
        }


    @Autowired
    private stu student;
    @RequestMapping("/stu11 ")
    public String tes(){
        System.out.println(student);
        return "hi";
    }



}
