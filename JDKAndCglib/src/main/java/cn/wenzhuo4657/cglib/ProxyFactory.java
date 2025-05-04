package cn.wenzhuo4657.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * @className: ProxyFactory
 * @author: wenzhuo4657
 * @date: 2024/6/15 9:50
 * @Version: 1.0
 * @description:
 */
public class ProxyFactory {
    private  Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public static  Object getProxy(Object target) {

        return Enhancer.create(target.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                Object result=null;
                try {
                    System.out.println("[===================]");
                    result = proxy.invoke(target,args);
                    System.out.println("[===================]");
                }catch (Exception E){
                    System.out.println(E);
                }
                return result;
            }
        });

    }
}