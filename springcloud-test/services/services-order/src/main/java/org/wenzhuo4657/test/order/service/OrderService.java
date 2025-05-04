package org.wenzhuo4657.test.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.wenzhuo4657.test.bean.Product;
import org.wenzhuo4657.test.order.feign.ProductFeignClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private ProductFeignClient productFeignClient;

    @SentinelResource("query")
    @GlobalTransactional
    public List<Product> queryProduct(long orderId){
        ArrayList<Product> list = new ArrayList<>();

        ServiceInstance instances ;
        for (int i=0;i<10;i++){

//            2，负载均衡
//            instances = loadBalancerClient.choose("services-product");
//            String url="http://"+instances.getHost()+":"+instances.getPort()+"/product/4";
//            System.out.println(url);

//            3，restTemplate自动负载均衡，在注入处使用注解 “ @LoadBalanced”,底层会自动调用loadBalancerClient，
//            这里实际上有一个问题，负载均衡的策略似乎无法从全局考虑，即我们无法得知其他主机的流量是什么？处于什么状态，我们只能将当前主机的流量平摊的每一个服务上，
//            换言之，我们无法动态调整负载均衡的策略，似乎不用考虑？
//            String url="http://services-product/product/"+orderId;
//            System.out.println(url);
//            Product res = restTemplate.getForObject(url, Product.class);


//            4,feign客户端调用

            Product query = productFeignClient.query(orderId);
            list.add(query);
        }
        return  list;
    }

}
