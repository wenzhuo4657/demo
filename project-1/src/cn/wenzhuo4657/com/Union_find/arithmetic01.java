package cn.wenzhuo4657.com.Union_find;

import java.io.*;
import java.util.Arrays;

/**
 * @className: arithmetic01
 * @author: wenzhuo4657
 * @date: 2024/6/3 11:49
 * @Version: 1.0
 * @description: 并查集简化版，节点未使用类表示，而是通过数组的序号和值表示，其值表示指向，序号表示当前节点，
 */
public class arithmetic01 {
    static int MaxNum=1001;
    static int[] father=new int[MaxNum];
    static int [] size=new int[MaxNum];
    static int [] stack=new int[MaxNum];
    public static int n;

    static {
        for (int i=0;i<MaxNum;i++){
            father[i]=i;
        }
        Arrays.fill(size,1);
    }

      /**
         *  des: 找到代表节点，并做扁平化处理
         * */
      static int find(int a){
        int index=0;
        while(a!=father[a]){
            stack[index++]=a;
            a=father[a];
        }
        for (int i=0;i<index;i++){
            father[stack[i]]=a;
        }
        return a;
    }

    static boolean isSameSet(int a, int b){
        return  find(a)==find(b);
    }
    static void union(int a, int b){
        int MarkA=find(a);
        int MarkB=find(b);
        if (MarkB==MarkA){
            return;
        }
        if (size[MarkA]>=size[MarkB]){
            father[MarkA]=MarkB;
            size[MarkB]+=size[MarkA];
        }else {
            father[MarkB]=MarkA;
            size[MarkA]+=size[MarkB];
        }
    }
}