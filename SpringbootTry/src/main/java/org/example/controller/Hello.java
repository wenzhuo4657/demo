package org.example.controller;

import com.google.common.base.Throwables;
import org.example.config.MyFeature;
import org.example.domain.ResponseResult;
import org.example.domain.enity.hello1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hello {
    Logger logger= LoggerFactory.getLogger(Hello.class);
    @Autowired
    private hello1 hello;

    @Autowired
    private MyFeature myFeature;



    @GetMapping("/i")
    public ResponseResult hello(){
//        myFeature.hello();
//        hello.hello();
//        try
//        {
//            logger.info("是这样吗");
//
//            int i=1/0;
//        }catch (Exception e){
//
//            logger.info(Throwables.getStackTraceAsString(e));
//        }
        return ResponseResult.okResult();
    }

}
