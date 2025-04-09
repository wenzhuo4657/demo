package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class helloword {
    public  void pring(){
        System.out.println("成功！！！！");
    }

    private  String name;
    private  String id;

    public helloword(String name, String id) {
        System.out.println("构造器注入执行");
        this.name = name;
        this.id = id;
    }

    public helloword() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "helloword{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
