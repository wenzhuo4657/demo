package cn.wenzhuo4657.com.si2;

import java.util.Arrays;

public class KMP {
    /*
     * @Author wenzhuo4657
     * @Description
     * 实际上是比较前缀，后缀
     * 匹配度意味着从该位置起向前有多少个字符与前缀相同
     * @return
     * 部分匹配表
     **/
    public static int []  table(String ds){
        int [ ] next=new int[ds.length()];
        next[0]=0;
        for (int i=1,j=0;i<next.length;i++){
            while (j>0&&ds.charAt(i)!=ds.charAt(j)){//此时j>next[j-1]必然成立
                j=next[j-1];
            }
            //这里的回溯首先要明白，前后两段字符串在相同位置的匹配绝对不相同（据匹配度的定义且错开一位，极限状况差为1，例如“aaaaaabaaaa”）
            // 也就是比较的是其他更小的前缀，并且是在省去了一定的操作继续向后比较
            if (ds.charAt(i)==ds.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return  next;
    }
/*
 * @Author wenzhuo4657
 * @Description
 * next：部分匹配表
 * @return
 * -1:没找到
 * i ：目标字符串的首字符位置
 **/
    public  static  int FindString(String Str,String Str1,int[] next){
        for (int i=0,j=0;i<Str.length();i++){
            while (j>0&&Str.charAt(i)!=Str1.charAt(j)){
                j=next[j-1];
            }
            if (Str.length()==Str1.length()){
                j++;
            }
            if (j==Str1.length()){
                return  i-j+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String a="asascfabcd";
        int [] s=table(a);
        System.out.println(Arrays.toString(s));
        System.out.println(FindString("aaa",a,s));
    }
}
