package org.example;

import java.beans.Transient;
import java.io.*;

public class HondaCar implements Car {


    private  String abb="aba";
//    @Transient(value = false)
    @Override
    public void run() {
        System.out.println("Honda");
    }

    public static void main(String[] args) {
        try {
            // 创建一个测试对象
            HondaCar obj = new HondaCar();
            // 输出流，持久化对象
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:\\code\\java\\idea\\try\\SPI\\tmp\\testObject.obj"));
            out.writeObject(obj);
            // 输入流，反序列化对象
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\code\\java\\idea\\try\\SPI\\tmp\\testObject.obj"));
            HondaCar newObj = (HondaCar) in.readObject();
            System.out.println(newObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}