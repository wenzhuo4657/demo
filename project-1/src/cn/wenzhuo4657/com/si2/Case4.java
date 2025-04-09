package cn.wenzhuo4657.com.si2;

import java.util.Arrays;

public class Case4 {

    public static void main(String[] args) {
        /*
        动态规划的实例：i/o背包问题
        * 问题描述：
        给定一定数量的完全不同（价格、占位/重量）的商品和一个容量有限的背包，在每件商品只能选取数量1的情况下，得出背包最大价值的装法
        * */
        int []  v={0,1500,3000,2000};//商品价值：为和表格对齐，从i=1开始填入
        int[]  w={0,1,4,3};//商品占位/重量
        String []  val={"","吉他","音响","电脑"};//商品名称，、

        int[][]  path=new int[4][5];//如果某种结果装入两种商品时，用于标记这个状态

        int [][] arr=new int[4][5];
        //第零行和第零列不用存储数据，防止数组索引越界
        //arr[i][j] 的意义为：在具有前i个商品、背包容量为j的情况下的最优解的背包最大价值

        for (int i=1;i< arr.length;i++){
            for (int j=1;j<arr[i].length;j++){
                if (w[i]>j){//如果装不进去，采取上一个格子的最优解
                    arr[i][j]=arr[i-1][j];
                }else {
                    //如果可以装进去，那么需要考虑和上一个最优解的比较
                    if (arr[i-1][j]>v[i]+arr[i-1][j-w[i]]){
                        //注意：由于是从零个商品开始，所以对于前面的格子一定是已经存储到值了
                        arr[i][j]=arr[i-1][j];
                    }else {
                        path[i][j]=1;//两种商品组合的只会在第一次存储，其余通过延续上一个最优解存储，但并不会改变path的值
                        arr[i][j]=v[i]+arr[i-1][j-w[i]];
                    }

                }
            }
        }
        for (int[] i: arr){
            System.out.println(Arrays.toString(i));
        }



    }
}
