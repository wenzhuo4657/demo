package org.wenzhuo4657.test.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wenzhuo4657.test.client.bean.NacosConfigInfo;

import java.security.PrivilegedAction;

@RestController
public class beanConfigController {



    @Autowired
    private  NacosConfigInfo nacosConfigInfo;
    @RequestMapping(method = RequestMethod.GET,value = "/api")
    public String queryConfig(){
        return  nacosConfigInfo.toString();

    }
}
