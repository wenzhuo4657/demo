package org.example.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/4
 * @description:
 */

@Data
public class Product {
    private  long id;
    private BigDecimal price;
    private  String  productName;
    private  int num;
}
