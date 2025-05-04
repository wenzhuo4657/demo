package org.wenzhuo4657.test.order.config;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.wenzhuo4657.test.bean.Product;
import org.wenzhuo4657.test.order.feign.ProductFeignClient;

@Component
public class myfallback implements ProductFeignClient {
    @Override
    public Product query(long id) {
        return null;
    }


    @Override
    public Product go(long id, String auth) {
        return null;
    }
}
