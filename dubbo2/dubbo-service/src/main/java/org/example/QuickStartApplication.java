package org.example;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableDubbo//启动dubbo组件作为bean使用
public class QuickStartApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(QuickStartApplication.class, args);
        new CountDownLatch(1).await();
    }

}