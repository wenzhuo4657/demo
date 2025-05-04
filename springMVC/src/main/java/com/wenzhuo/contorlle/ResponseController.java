package com.wenzhuo.contorlle;


import com.wenzhuo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RequestMapping("/Response")
@RestController
public class ResponseController {

    @RequestMapping("/test/{id}")
    public User testResqoneBody(@PathVariable Integer id){
        System.out.println("testResqoneBody启动---");
        User user=new User(id,null,null);
        return  user;
    }

    @RequestMapping("/test")
    public List<User> testResponseList(){
        List<User> list = new ArrayList<User>();
        list.add(new User(1,"三更",15));
        list.add(new User(2,"四更",16));
        list.add(new User(3,"五更",17));
        return list;
    }



}
