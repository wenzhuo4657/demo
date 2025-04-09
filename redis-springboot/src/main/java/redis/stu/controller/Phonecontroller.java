package redis.stu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @className: controller
 * @author: wenzhuo4657
 * @date: 2024/5/9 15:03
 * @Version: 1.0
 * @description:
 */
@RestController
@Slf4j
public class Phonecontroller {

    @Resource
    private JedisPool jedisPool;
    int phonecode=4432;

    @RequestMapping(value = "/rs")
    public  void test() {

    }

}