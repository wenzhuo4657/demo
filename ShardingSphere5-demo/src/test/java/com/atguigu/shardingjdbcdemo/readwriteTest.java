package com.atguigu.shardingjdbcdemo;

import com.atguigu.shardingjdbcdemo.entity.Order;
import com.atguigu.shardingjdbcdemo.entity.User;
import com.atguigu.shardingjdbcdemo.mapper.OrderMapper;
import com.atguigu.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @className: readwriteTest
 * @author: wenzhuo4657
 * @date: 2024/7/28 11:52
 * @Version: 1.0
 * @description:
 */
@SpringBootTest
public class readwriteTest {

    private UserMapper userMapper;


    private OrderMapper orderMapper;

    @Autowired
    public readwriteTest(UserMapper userMapper, OrderMapper orderMapper) {
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
    }

    @Test
    public void testInsert(){

        User user = new User();
        user.setUname("张三丰");
        userMapper.insert(user);
    }


    @Test
    public void testInsertOrder(){

        Order order = new Order();
        order.setOrderNo("ATGUIGU001");
        order.setUserId(1L);
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
    }


    /**
     * 水平分片：分表插入数据测试
     */
    @Test
    public void testInsertOrderTableStrategy(){

        for (long i = 1; i < 5; i++) {

            Order order = new Order();
            order.setOrderNo("ATGUIGU" + i);
            order.setUserId(1L);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
        }

        for (long i = 5; i < 9; i++) {

            Order order = new Order();
            order.setOrderNo("ATGUIGU" + i);
            order.setUserId(2L);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
        }
    }

    /**
     * 测试哈希取模
     */
    @Test
    public void testHash(){

        //注意hash取模的结果是整个字符串hash后再取模，和数值后缀是奇数还是偶数无关
        System.out.println("ATGUIGU001".hashCode() % 2);
        System.out.println("ATGUIGU0011".hashCode() % 2);
    }
}