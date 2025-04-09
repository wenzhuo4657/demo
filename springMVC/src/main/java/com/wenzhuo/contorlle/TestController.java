package com.wenzhuo.contorlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
//当该注解标记在类上时，说明必须使用“/test/hello”的形式访问其内部定义的请求方法
public class TestController {

    @RequestMapping("/hello")//指定请求路径是/hello的才能被该方法处理
    public String hello(String name){
        System.out.println("hello");
        System.out.println(name);
        return "/success.jsp";//跳转到success.jsp静态资源
    }


        @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
        public String testMethod(){
            System.out.println("testMethod处理了请求");
            return "/success.jsp";
        }

    @RequestMapping(value = "/testConsumes",method = RequestMethod.POST,consumes = "multipart/from-data")
    public String testConsumes(){
        System.out.println("testConsumes处理了请求");
        return "/success.jsp";
    }

    @RequestMapping(value = "/testHeaders",method = RequestMethod.GET,headers = "deviceType=ios")
    public String testHeaders(){
        System.out.println("testHeaders处理了请求");
        return "/success.jsp";
    }

    @RequestMapping("/testJumpToJsp")
    public String testJumpToJsp(){
//        return "/WEB-INF/page/test.jsp";
        System.out.println("跳转？");
        return "success";
    }

    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "test";
    }

        @RequestMapping("/testRquestScope")
        public String testRquestScope(Model model){
            //往请求域存数据
            model.addAttribute("name","三更");
            model.addAttribute("title","不知名Java教程UP主");
            return "success";
        }


        @RequestMapping("/testRquestScope2")
        public ModelAndView testRquestScope2(ModelAndView modelAndView){
            //往域中添加数据
            modelAndView.addObject("name","三更");
            modelAndView.addObject("title","不知名Java教程UP主");
            //页面跳转
            modelAndView.setViewName("success");
            return modelAndView;
        }



        @RequestMapping("/testGetAttribute")
        public String testGetAttribute(@RequestAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingPattern")
                                       String value, HttpServletRequest request){
            System.out.println(value);

            return "success";
        }



}