package com.wenzhuo4657.controller;




import com.wenzhuo4657.domain.ResponseResult;
import com.wenzhuo4657.domain.User;

import com.wenzhuo4657.service.findallService;
import com.wenzhuo4657.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
@ResponseBody
public class fin {


    @Autowired
    private findallService findallService;

    @GetMapping(value = "/findall")
    public ResponseResult fin(){
        List<User> list=findallService.findall();
        return  new ResponseResult(200,list);
    }
//
//    @GetMapping(value = "/fins")
//    @ResponseBody
//    public List<User> fins(){
//        List<User> list=findallService.findall();
//        ResponseResult responseResult=new ResponseResult(200,list);
//        return  (List<User>) responseResult.getList();
//
//    }


    @RequestMapping("/find")
    public ResponseResult loginn(HttpSession session) throws Exception {
        String  token=(String) session.getAttribute("token");
        if (StringUtils.hasText(token)){
            Claims claims= JwtUtil.parseJWT(token);
            System.out.println(claims.getSubject());
            return  new ResponseResult<>(200,"token有效");
        }
        return new ResponseResult<>(300,"token无效");
    }

    @RequestMapping(value = "/ada")
    public  String users(){
        return  "table-standard";
    }

}
