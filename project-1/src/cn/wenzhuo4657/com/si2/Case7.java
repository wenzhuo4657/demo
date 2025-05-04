package cn.wenzhuo4657.com.si2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Case7 {
    //贪心算法实例：集合覆盖问题
    //问题描述：选取集合覆盖所有城市，
    public static void main(String[] args) {
        //选择的广播站序列
        HashMap<dow, HashSet> bost = new HashMap<>();

        HashSet bo1 = new HashSet<>();
        bo1.add("北京");
        bo1.add("上海");
        bo1.add("天津");
        HashSet bo2 = new HashSet<>();
        bo2.add("广州");
        bo2.add("北京");
        bo2.add("深圳");
             HashSet    bo3 = new HashSet<>();
        bo3.add("成都");
        bo3.add("上海");
        bo3.add("深圳");
        HashSet  bo4 = new HashSet<>();
        bo4.add("上海");
        bo4.add("天津");
        HashSet bo5 = new HashSet<>();
        bo5.add("杭州");
        bo5.add("大连");

        dow boo1=new dow("bo1",bost);
        dow boo2=new dow("bo2",bost);
        dow boo3=new dow("bo3",bost);
        dow boo4=new dow("bo3",bost);
        dow boo5=new dow("bo5",bost);
        bost.put(boo1,bo1);
        bost.put(boo2,bo2);
        bost.put(boo3,bo3);
        bost.put(boo4,bo4);
        bost.put(boo5,bo5);


        //未被选择的地区
        ArrayList<Object> sec = new ArrayList<>();
        sec.add("北京");
        sec.add("上海");
        sec.add("天津");
        sec.add("广州");
        sec.add("深圳");
        sec.add("成都");
        sec.add("杭州");
        sec.add("大连");


        //选择广播站序列
        ArrayList<String> alls = new ArrayList<>();

        //当前广播站覆盖地区与sec地区的交集
        ArrayList<String> ma=new ArrayList<>();


        //存储ma最大的广播站名称
        dow max=null;
        //存储max指向广播站的ma数量,
        int  maxNum;


        while (sec.size()!=0){
            maxNum=0;
            max=null;
            for (dow bo:bost.keySet()){
                System.out.println(bo.BO);
                ma.clear();
                ma.addAll(bost.get(bo));
                ma.retainAll(sec);
                if (ma.size()>0&&(ma.size()>maxNum)){
                    max=bo;
                    maxNum=ma.size();
                }
            }
            if (maxNum!=0){
                bost.remove(bost.get(max));
            }
            if (maxNum>0){
                alls.add(max.BO);
                if (bost.get(max)!=null){
                    sec.removeAll(bost.get(max));

                }

            }

        }


        System.out.println(alls.toString());



    }


}

class dow{

    String BO;

    HashMap a;//该类对象将要存储进的集合
    int b;//集合容量：在hashcode函数内实现动态更新

    public dow( String BO, HashMap a) {
        this.BO = BO;
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (o  instanceof  dow){
            if (BO.equals(((dow) o).BO)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        try {
            b=max();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        char c=BO.charAt(BO.length()-1);
        int d= Integer.parseInt(c+"");


        return c;
    }

    public  int max() throws NoSuchFieldException, IllegalAccessException {

        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(a);

        int capacity = table == null ? 0 : table.length;
        return  capacity;
    }
}
