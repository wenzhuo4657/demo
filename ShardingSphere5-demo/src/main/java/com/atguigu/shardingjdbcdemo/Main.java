package com.atguigu.shardingjdbcdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className: Main
 * @author: wenzhuo4657
 * @date: 2024/7/28 11:10
 * @Version: 1.0
 * @description:
 */
@SpringBootApplication
@MapperScan("com.atguigu.shardingjdbcdemo.mapper")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}