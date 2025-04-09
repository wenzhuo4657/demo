package org.example.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class    HelloWorldController {
    @GetMapping(value="/hello")
    @ResponseBody
    public String hello(ModelAndView model){
        return "<h1>@EnableWebMvc 你好</h1>";
    }
}