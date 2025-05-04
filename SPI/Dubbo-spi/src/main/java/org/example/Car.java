package org.example;


import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI()
public interface Car {


    void run();
}