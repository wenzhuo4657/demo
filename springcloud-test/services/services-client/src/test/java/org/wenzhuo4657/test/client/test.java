package org.wenzhuo4657.test.client;


import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.util.List;

@SpringBootTest
public class test {



     @Autowired
    DiscoveryClient discoveryClient;


//     服务发现测试
     @Test
    void test(){
         for (String service: discoveryClient.getServices()){
             System.out.println("service: "+service);

             List<ServiceInstance> instances = discoveryClient.getInstances(service);

             for (ServiceInstance instance: instances){
                 System.out.println("ip: "+instance.getHost()+";port: "+instance.getPort());
             }
         }
     }


     @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery;


//     服务发现测试
    @Test
    void test1() throws NacosException {
        for (String service: nacosServiceDiscovery.getServices()){
            System.out.println("service: "+service);

            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);

            for (ServiceInstance instance: instances){
                System.out.println("ip: "+instance.getHost()+";port: "+instance.getPort());
            }
        }
    }

//    负载均衡测试
//    todo springcloud由哪些负载均衡错误？

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    void test3(){
        ServiceInstance choose = loadBalancerClient.choose("services-product");
        System.out.println(choose.getHost()+":"+choose.getPort());
        choose = loadBalancerClient.choose("services-product");
        System.out.println(choose.getHost()+":"+choose.getPort());
        choose = loadBalancerClient.choose("services-product");
        System.out.println(choose.getHost()+":"+choose.getPort());
        choose = loadBalancerClient.choose("services-product");
        System.out.println(choose.getHost()+":"+choose.getPort());
        choose = loadBalancerClient.choose("services-product");
        System.out.println(choose.getHost()+":"+choose.getPort());

    }


}
