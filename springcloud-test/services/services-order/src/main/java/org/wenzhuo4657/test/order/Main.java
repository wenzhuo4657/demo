package org.wenzhuo4657.test.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients  //开启feign远程调用功能
@EnableDiscoveryClient
@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
