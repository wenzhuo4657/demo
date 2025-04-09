package org.example.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.DemoService;


@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
