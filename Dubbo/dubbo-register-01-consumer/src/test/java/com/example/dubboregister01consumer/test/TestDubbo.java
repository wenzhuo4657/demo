package com.example.dubboregister01consumer.test;

import cn.wenzhuo4657.dubbo.study.first.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @className: TestDubbo
 * @author: wenzhuo4657
 * @date: 2024/6/23 16:58
 * @Version: 1.0
 * @description:
 */
@SpringBootTest
@DubboComponentScan("com")
public class TestDubbo {

    @DubboReference
    private UserService userService;


    @Test
    public void test() throws IOException {
        String xiaohei = String.valueOf(userService.login("xiaohei", "11111"));
        System.out.println("xiaohei = " + xiaohei);
        System.in.read();
    }
}