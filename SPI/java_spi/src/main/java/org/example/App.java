package org.example;


import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        ServiceLoader<Car> load = ServiceLoader.load(Car.class);

//        获取迭代器遍历
        Iterator<Car> iterator = load.iterator();
        while (iterator.hasNext()){
            Car registry = iterator.next();
            registry.run();
        }

//        forEach(直接调用迭代器方法)
//        load.forEach(x->x.run());
    }
}