package org.example.ioc;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;
import org.example.Car;

/**
 * @author: wenzhuo4657
 * @date: 2024/11/12
 * @description:
 */
public class PenRes implements Pen {

      Res res;

    public Res getRes() {
        return res;
    }


    public void setRes(Res res) {
        this.res = res;
    }

    @Override
    public void run(URL url) {
        res.run();
        System.out.println("PenRes");
    }


}
