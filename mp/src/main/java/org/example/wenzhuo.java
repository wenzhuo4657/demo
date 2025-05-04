package org.example;


import org.example.mapper.UserMapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.mapper")
public class wenzhuo {

    public static void main(String[] args) {
        SpringApplication.run(wenzhuo.class);
    }



}