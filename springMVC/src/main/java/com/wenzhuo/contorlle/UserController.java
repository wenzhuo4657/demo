package com.wenzhuo.contorlle;


import com.wenzhuo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {
    @RequestMapping(value = "/findUserById/{id}",method = RequestMethod.GET)
    public String findUserById( @PathVariable("id")Integer id){
        System.out.println("findUserById");
        System.out.println(id);
        return "/success.jsp";
    }



        @RequestMapping(value = "/getuser",method = RequestMethod.POST)
        public String insertUser(@RequestBody List<User> user){
            System.out.println("insertUser");
            System.out.println(user);
            return "success";
        }

    @RequestMapping("/testRquestParam")
    public String testRquestParam( Integer uid,  String name,String[] likes){
        System.out.println("testRquestParam");
        System.out.println(uid);
        System.out.println(name);
        System.out.println(Arrays.toString(likes));
        return "success";
    }

    @RequestMapping("/getDate")
    public String getDate(Date date){
        System.out.println(date);
        return "success";
    }

}
