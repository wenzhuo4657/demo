package org.wenzhuo4657.test.client.controller;


import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class ConfigListenerExample {



    private String DATAID="server-order.properties";
    private  String GROUTP="my_discovery";


    @Autowired
    private NacosConfigManager nacosConfigManager;

    @PostConstruct//在bean注入完成之后调用，用于完成一些初始化任务
    public void init() throws NacosException {
        ConfigService configService = nacosConfigManager.getConfigService();
        configService.addListener(DATAID, GROUTP, new Listener() {
            @Override
            public Executor getExecutor() {
                //获取该监听器的执行者，直白点就是下面这个receiveConfigInfo方法的执行线程
                return Executors.newSingleThreadExecutor();
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println(configInfo);
            }
        });

    }





}
