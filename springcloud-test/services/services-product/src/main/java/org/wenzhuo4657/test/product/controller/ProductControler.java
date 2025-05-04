package org.wenzhuo4657.test.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wenzhuo4657.test.bean.Product;

@RestController
public class ProductControler {


    @Autowired
    private Environment env;
    @GetMapping("product/{id}")
    public  Product query(@PathVariable("id") Long productId) {

        String property = env.getProperty("local.server.port");
        System.out.println(property);
        return new Product();
    }




}
