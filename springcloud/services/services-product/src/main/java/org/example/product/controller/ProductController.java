package org.example.product.controller;

import org.example.product.bean.Product;
import org.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/4
 * @description:
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        Product product=productService.getProduct(id);
        return  product;
    }
}
