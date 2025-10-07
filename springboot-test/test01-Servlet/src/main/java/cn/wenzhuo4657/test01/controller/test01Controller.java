package cn.wenzhuo4657.test01.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test01Controller {


    @RequestMapping("/")
    public String index(){
        return "1";
    }
}
