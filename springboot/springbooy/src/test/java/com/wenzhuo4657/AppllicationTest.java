package com.wenzhuo4657;

import com.wenzhuo4657.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppllicationTest {


    @Test
    public void junitTest(){
        System.out.println(1);
    }


    @Autowired
    private UserMapper userDao;


    @Test
    public void userTest(){
        System.out.println(userDao.findAll());
        System.out.println("=========");
    }
}
