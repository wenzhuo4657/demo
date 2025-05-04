package com.wenzhuo4657.thymeleaf;


import com.wenzhuo4657.service.UserService;
import com.wenzhuo4657.service.findallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.List;

@Controller
public class ThymeleafController {
    @Autowired
    private findallService userService;

@RequestMapping(value = "/ad")
    public  String users(Model model){
        List list=userService.findall();
        model.addAttribute("users",list);
        model.addAttribute("msg","hello");



        return  "table-standard";
//        Thymeleaf 视图解析器会将返回值自动补全为table-standard.html


    }


}
