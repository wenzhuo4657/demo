package cn.wenzhuo4657.com.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/5/17 15:16
 * @Version: 1.0
 * @description:
 */
public class test {
    static int [][] dp;

 /**
   *  des:
  *  aw:重量
  *  ap:价值
  *  top：容量
   * */
    public static int   OptimalSolution(int[] aw,int[]  ap,int top){
        dp=new int[aw.length+1][top+1];

        for (int i=1;i<dp.length;i++){//物品栏增加
            for (int j=1;j<dp[i].length;j++){//背包容量增加
                if (j>=aw[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-aw[i-1]]+ap[i-1]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[aw.length][top];

    }

    public static void main(String[] args) {
        int i = OptimalSolution(new int[]{2, 3, 5, 7, 1, 4, 1}, new int[]{10, 5, 20, 7, 6, 18, 3}, 15);
        System.out.println(i);
    }
}