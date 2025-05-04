package com.wenzhuo4657.config;


import com.wenzhuo4657.domain.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {





    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseResult handlerExcpetion(Exception e){
        String msg=e.getMessage();
        return  new ResponseResult<>(300,msg);
    }
}
