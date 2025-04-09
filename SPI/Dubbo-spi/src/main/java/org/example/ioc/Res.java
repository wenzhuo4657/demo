package org.example.ioc;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Res {

    @Adaptive({"Race"})
    void run();
}