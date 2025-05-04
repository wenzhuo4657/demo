package org.wenzhuo4657.test.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
