package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class reflection {
    public static void main(String[] args) throws Exception {
        Properties properties =new Properties();
        properties.load(new FileInputStream("D:\\学习\\编译\\idea-project\\reflection\\src\\main\\resources\\re.properties"));
        String classfullpath=properties.get("classfullpath").toString();
        String methodName=properties.get("method").toString();



        Class cls=Class.forName(classfullpath);
        System.out.println(cls);
        Object o=cls.newInstance();
        System.out.println("o运行类型；"+o.getClass());
        Method method= cls.getMethod(methodName);
        System.out.println("======================");
        method.invoke(o);

        Field field=cls.getField("age");
        System.out.println("age:"+field.get(o));
        Constructor constructor= cls.getConstructor();
        constructor.setAccessible(true);
        System.out.println("无参构造器：  "+constructor);
        System.out.println("有参构造器：   "+cls.getConstructor(int.class));


    }
}
