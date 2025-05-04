package org.example;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.example.aop.CarWrapper1;
import org.example.aop.CarWrapper2;
import org.example.ioc.Pen;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: wenzhuo4657
 * @date: 2024/11/12
 * @description:
 */


public class test {

    ExtensionLoader<Car> extensionLoader;
    @Before
    public void  fi(){
        extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
    }


    /**
     *  @author:wenzhuo4657
        des:
    dubbo基本服务发现，和jdk的主要区别在于可以用键去获取指定的扩展实现。
    */
        @Test
        public void test(){
            Car car = extensionLoader.getExtension("ali",false);//false表示不进行自动装配等其他配置，默认为true,
            car.run();
            if (car instanceof HondaCar){
                System.out.println("true");
            }
        }


/**
 *  @author:wenzhuo4657
    des:  一个wrapper包装
        编写wrapper包装类，并且在配置文件使用 wrapper=全限定类名指定，
*/
        @Test
        public void WarpperTest(){
            Car car = extensionLoader.getExtension("honda");//默认开启自动装配，
            car.run();
            if (car instanceof HondaCar){
                System.out.println("运行类型：HondaCar");
            }
            if (car instanceof CarWrapper1){
                System.out.println("运行类型：CarWrapper1");
            }
        }

        /**
         *  @author:wenzhuo4657
            des:多个warpper包装类之间的次序，
         在配置文件中使用多个warpper的键，这些包装类之间的加载次序可以通过@Activate(order = 2)控制，值越小优先级越高
        */
    @Test
    public void ManyWarpperTest(){

        Car car = extensionLoader.getExtension("honda");
        car.run();
        if (car instanceof CarWrapper2){
            System.out.println("运行类型：CarWrapper2");
        }
        if (car instanceof CarWrapper1){
            System.out.println("运行类型：CarWrapper1");
        }
    }

/**
 *  @author:wenzhuo4657
    des: 扩展中存在其他扩展，进行注入测试(单实现注入)
*/
    @Test
    public void setterTest(){
        ExtensionLoader<Pen> extensionLoader=ExtensionLoader.getExtensionLoader(Pen.class);
        Pen pen = extensionLoader.getAdaptiveExtension();
        URL url = new URL("dubbo", "127.0.0.1", 20880).
                addParameter("WheelMaker", "wheel").
                addParameter("CarMaker","car");

        // 调用方法
        pen.run(url);
    }






}
