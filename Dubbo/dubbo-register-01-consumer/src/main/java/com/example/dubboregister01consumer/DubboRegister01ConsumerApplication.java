package com.example.dubboregister01consumer;

import cn.wenzhuo4657.dubbo.study.first.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DubboRegister01ConsumerApplication {



    public static void main(String[] args) {
        SpringApplication.run(DubboRegister01ConsumerApplication.class, args);

    }

}
