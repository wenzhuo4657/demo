package org.example.product.service.impl;

import org.example.product.bean.Product;
import org.example.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/4
 * @description:
 */
@Service
public class ProductServiceImpl  implements ProductService {
    @Override
    public Product getProduct(Long id) {

        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal(id*1000+""));
        product.setProductName("苹果----");
        product.setNum((int)(id*232));
        return product;
    }
}
