package com.example.dubbo02bootconsumer;

import cn.wenzhuo4657.dubbo.study.first.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Dubbo02BootConsumerApplicationTests {
    @DubboReference(url = "dubbo://192.168.213.1:20880/cn.wenzhuo4657.dubbo.study.first.service.UserService")
    private UserService userService;

    @Test
    void contextLoads() {
        boolean b = userService.login("小明", "1324654");
        System.out.println(b);
    }

}
