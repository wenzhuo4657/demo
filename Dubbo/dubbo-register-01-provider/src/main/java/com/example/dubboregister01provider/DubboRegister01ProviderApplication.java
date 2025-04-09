package com.example.dubboregister01provider;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboRegister01ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRegister01ProviderApplication.class, args);
    }

}
