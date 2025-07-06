package com.wenzhuo4657.config;

import com.wenzhuo4657.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class TestConfig {


    private User name;


    @PostConstruct
    public void init(){
        name=new User();
    }

    @PreDestroy
public void destroy(){
        name=null;
    }


    public User getName() {
        return name;
    }
}
