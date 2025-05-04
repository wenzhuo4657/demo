package org.wenzhuo4657.test.client.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "order")
@Component
public class NacosConfigInfo {

    public   String  time;
    public  String  enable;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "NacosConfigInfo{" +
                "time='" + time + '\'' +
                ", enable='" + enable + '\'' +
                '}';
    }
}
