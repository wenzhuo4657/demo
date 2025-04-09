package cn.wenzhuo4657.jdk;

import cn.wenzhuo4657.jdk.stu;

/**
 * @className: stu
 * @author: wenzhuo4657
 * @date: 2024/6/14 16:20
 * @Version: 1.0
 * @description:
 */
public class stuImpl implements stu {
    int code;
    String name;
    @Override
    public  void goSchool() {
        System.out.println("进去学校");
    }

    public  void test(){
        System.out.println("这是test");
    }
}