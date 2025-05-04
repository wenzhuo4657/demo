package org.wenzhuo4657.test.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.wenzhuo4657.test.bean.Product;
import org.wenzhuo4657.test.order.config.myfallback;

//@FeignClient("services-product")   //远程服务定义
@FeignClient(value = "services-product",fallback = myfallback.class)   //第三方api访问
public interface ProductFeignClient {


    @GetMapping("product/{id}")
    public Product query(@PathVariable("id")  long id);

    @PostMapping("product/{id}")
    public Product go(@PathVariable("id")  long id, @RequestHeader("authorization") String auth);

}
