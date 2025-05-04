package cn.wenzhuo4657.Round2.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/13
 * @description:
 */
public class Utils {

    /**
     * 随机数组生成器，此方法可以生成普通数字类型,浮动数字类型 字符串类型的数组
     * 推荐使用：整数类型 Integer 浮动数类型 Double 字符串类型 String
     * @param type 元素类型
     * @param count 数组大小
     * @param <T> 泛型类型
     * @return 返回生成后的数组
     */
    public static <T extends Comparable> Object[] makeRandomArray(T type,Integer count) throws Exception {
        Object[] result=new Object[count];
        Class cl=type.getClass();
        Constructor[] constructors=cl.getDeclaredConstructors();
        Constructor constructor=null;
        for(Constructor constructor1:constructors){
            Class[] types = constructor1.getParameterTypes();
            if(types.length==1&&types[0]==String.class){
                constructor=constructor1;
                break;
            }
        }
        if(constructor==null){
            throw new Exception("此类型不支持生成随机类型");
        }
        for(int i=0;i<count;i++){
            String emuStr=null;
            double emu = 0;
            if(type.getClass()==String.class){
                int strLength=(int)(Math.random()*10);
                if(strLength<1){
                    strLength=1;
                }
                StringBuilder strBul=new StringBuilder();
                for(int j=0;j<strLength;j++){
                    int num=(int)(Math.random()*122);
                    while (num<97){
                        num=(int)(Math.random()*122);
                    }
                    char letter=(char) num;
                    strBul.append(letter);
                }
                emuStr=strBul.toString();
            }else{
                emu=(Math.random()*1000);
                emuStr= Double.toString(emu);
            }
            try{
                result[i]=constructor.newInstance(emuStr);
            }catch (Exception e){
                int emuInt=(int)emu;
                emuStr=Integer.toString(emuInt);
                result[i]=constructor.newInstance(emuStr);
            }
        }
        return  result;
    }
    public  static  int [] generateIntArray(int [] arr){
        Object[] objects = new Object[0];
        try {
            objects = Utils.makeRandomArray(new Integer(1), arr.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < objects.length; i++) {
            arr[i] = (int) objects[i];
        }

//        设置固定的相等的数字
        for (int i = 3; i <6 ; i++) {
            arr[i] = 2000;
        }

        return  arr;
    }


    public static <T>boolean testInt(int num, T obj,Method method,Object[] args){
        for(int i=0;i<num;i++){
            if(!testInt(obj,method,args)){
                return  false;
            }
        }
        return  true;
    }

    public static <T>boolean testInt(T obj, Method method, Object[] args) {
        try {
            System.out.println("====================");
            printLog(method.getParameterTypes(),args);
            method.invoke(obj,args);
            printLog(method.getParameterTypes(),args);
            System.out.println("=====================");
        } catch (Exception e){
            System.out.println("排序算法出错");
        }
        return true;
    }

    private static void printLog(Class<?>[] parameterTypes, Object[] args){
        for(int i=0;i< parameterTypes.length;i++){
            Class<?> parameterType = parameterTypes[i];
            Object arg = args[i];
            if (parameterType.isArray() && parameterType.getComponentType().equals(int.class)) {
                // 如果参数类型是 int[]
                System.out.println(" "+ parameterType.getSimpleName() + ", 值： " + Arrays.toString((int[]) arg));
            }else {
                System.out.println("  "  + parameterType.getSimpleName() + ", 值： " + arg);
            }

        }

        Arrays.sort();

    }



}
