package org.example.ioc;

import org.apache.dubbo.common.URL;
import org.example.Car;

/**
 * @author: wenzhuo4657
 * @date: 2024/11/12
 * @description:
 */
public class RaceRes implements Res {
//    private  Car car;
//
//    public RaceRes(Car car) {
//        this.car = car;
//    }

    @Override
    public void run() {
        System.out.print("这是res拥有");
//        System.out.println(car.getClass().getSimpleName());
    }

//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    public Car getCar() {
//        return car;
//    }
}
