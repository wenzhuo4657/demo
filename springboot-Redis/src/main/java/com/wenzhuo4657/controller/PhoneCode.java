package com.wenzhuo4657.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@Slf4j
public class PhoneCode {

    @Autowired
    private JedisPool jedisPool;


    /**
    * 验证码服务
    * */


    public  int phonecode(){
        int code=(int )(Math.random()*10000);
        return  code;
    }


    @GetMapping(value = "/get")
    public  String getcode(@RequestParam("phoneNum") String phone){
        //获得连接池对象
        Jedis jedis=jedisPool.getResource();
        String key ="phoneKey:"+phone;
        int code=phonecode();
        if (jedis.exists(key)){
            return "验证码未过期----";
        }else {
            log.info("验证码已发送："+code);
            jedis.set(key,code+"");
            jedis.expire(key,60);
            return "验证码发送成功";
        }


    }

}
