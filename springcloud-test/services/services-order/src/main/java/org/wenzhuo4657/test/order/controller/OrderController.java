package org.wenzhuo4657.test.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.wenzhuo4657.test.bean.Order;
import org.wenzhuo4657.test.bean.Product;
import org.wenzhuo4657.test.order.feign.ProductFeignClient;
import org.wenzhuo4657.test.order.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @GetMapping("order/{id}")
    public Order query(@PathVariable("id") Long orderId) {
        Order order = new Order();
        order.orderId=orderId.toString();
        order.products=orderService.queryProduct(orderId);
        return order;
    }


    @Autowired
    private LoadBalancerClient loadBalancerClient;




}
