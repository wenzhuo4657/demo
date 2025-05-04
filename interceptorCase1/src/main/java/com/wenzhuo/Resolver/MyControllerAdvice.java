package com.wenzhuo.Resolver;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MyControllerAdvice {

//    @ExceptionHandler({NullPointerException.class,ArithmeticException.class})
//    public ModelAndView handlerException(Exception ex){
//        //如果出现了相关的异常，就会调用该方法
//        String msg = ex.getMessage();
//        ModelAndView modelAndView = new ModelAndView();
//        //把异常信息存入域中
//        modelAndView.addObject("msg",msg);
//        //跳转到error.jsp
//        modelAndView.setViewName("/WEB-INF/page/error.jsp");
//        return modelAndView;
//    }
}