package org.example.aop;

import org.apache.dubbo.common.extension.Activate;
import org.example.Car;

/**
 * @author: wenzhuo4657
 * @date: 2024/11/12
 * @description:
 */
@Activate(order = 2)
public class CarWrapper1 implements Car {
    private final Car car;

    public CarWrapper1(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        System.out.print("CarWrapper1包含");
        car.run();
    }
}
