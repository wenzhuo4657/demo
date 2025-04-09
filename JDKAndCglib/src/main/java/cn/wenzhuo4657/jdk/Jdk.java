package cn.wenzhuo4657.jdk;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.commons.lang3.ArrayUtils;
/**
 * @className: jdk
 * @author: wenzhuo4657
 * @date: 2024/6/14 16:19
 * @Version: 1.0
 * @description:
 */
public class Jdk implements InvocationHandler {
    Object target;//jdk需要一个可以实例化的类，

    public Jdk(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> cls = target.getClass();
        Field[] fields = cls.getFields();
        before(fields,cls.getMethods());
        Object result = method.invoke(target, args);//调用target的method方法
        return result;
    }

    private void before(Field []  fields, Method[] methods){
        System.out.println("可访问字段："+ArrayUtils.toString(fields));
        System.out.println("可访问方法："+ArrayUtils.toString(methods));

    }
}