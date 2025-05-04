package org.wenzhuo4657.test.order.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.RetryableException;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import reactor.util.retry.Retry;

import java.security.PrivilegedAction;

@Configuration
public class AppConfig {

    @LoadBalanced    //为http客户端增加负载均衡功能，即自动切换ip:port
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }










}
