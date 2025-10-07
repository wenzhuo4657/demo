package org.example;

public class recordTest {

//   record  密封类： 提供一种紧凑的语法来定义类中的不可变数据。
    record  person(String name,int age){
        static String a;
        static {
            a = "a";
        }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        person.a = a;
    }
}

    public static void main(String[] args) {
        person p = new person("Mike", 23);
        System.out.println(p);

        System.out.println(p.getA());
        p.setA("b");
        System.out.println(p.getA());

    }
}
