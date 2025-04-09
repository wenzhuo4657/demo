package com.example.dubbo02bootprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@DubboComponentScan(basePackages = {"com.example"})
public class Dubbo02BootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo02BootProviderApplication.class, args);
    }

}
