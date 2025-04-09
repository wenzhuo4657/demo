package com.junit.case5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:spring-junit.xml")
public class Testjunit5 {

    @Autowired
    private User user;

    @Test
    public void testuser(){
        System.out.println(user);
        user.ss();
    }
}
