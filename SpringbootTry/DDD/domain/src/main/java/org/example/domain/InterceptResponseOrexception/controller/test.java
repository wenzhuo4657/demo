package org.example.domain.InterceptResponseOrexception.controller;


import org.example.domain.InterceptResponseOrexception.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestController
public class test {

    @RequestMapping("/test")
    public List test()
    {
        return Arrays.asList("test");
    }


    @RequestMapping("/test2")
    public List test2() throws ServiceException {
        throw  new ServiceException("500","test2");
    }
}
