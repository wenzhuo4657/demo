package org.example.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/4
 * @description:
 */
@SpringBootTest
public class springbootTest {


    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;




    /**
     *  @author:wenzhuo4657
        des:
     服务发现测试
    */
    @Test
    public  void test1(){
//        nacosServiceDiscovery.getServices();
//        nacosServiceDiscovery.getInstances();
        for (String service:discoveryClient.getServices()){
            System.out.println("service: "+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);

            for (ServiceInstance instance:instances){
                System.out.println("ip:"+instance.getHost()+";port:"+instance.getPort());
            }

        }
    }
}
