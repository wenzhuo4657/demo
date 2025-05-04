package cn.wenzhuo4657.com.si2;

import java.io.*;

abstract public class Case1 {


    public static void main(String[] args) throws Exception, IOException {
              int [][] a=new int[7][8];
              for (int i=0;i<a.length;i++){
                  a[i][0]=1;
                  a[i][7]=1;
              }
              for (int i=0;i<a[0].length;i++){
                  a[0][i]=1;
                  a[6][i]=1;
              }
              a[3][1]=1;
              a[3][2]=1;
              print(a);
              if (Find(a,2,3)){
                  System.out.println("找到路了");
                  print(a);
              }


    }
    public  static   void print(int [][] m){
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
/*
 * @Author wenzhuo4657
 * @Description  生成到达目标的路线，不保证最优
 * @Date
 * @Param i、j,表示起始点坐标
 * @return true或者false
 **/
    public static boolean Find(int [][] m,int i,int j){
        if (m[5][4]==2){
            return  true;
        }else {
            /*
            * 为了方便找路线，我们进行规定
            * 0：该路向没有走过
            * 1：墙
            * 2：走过
            * 3：此路不能到达目标
            * 为选择路线方向时，顺序为下、右、上、左
            * (注意：该递归前进的方向始终遵循上左下右，且需要注意的
            * 该递归没有实现异步编程，所以在同一时刻该递归只会进行一个操作，
            * 即在上一步操作没有完成时，不会向下进行）
            * 且该路线没有重复
            * */

            if (m[i][j]==0){
                m[i][j]=2;
                if (Find(m,i-1,j)){
                    return true;
                }else if (Find(m,i,j+1)){
                    return true;
                }else if (Find(m, i+1, j)){
                    return true;
                }else if ((Find(m, i, j-1))){
                    return  true;
                }else {
                    m[i][j]=3;
                    return false;
                }
            }else {
                /*
                * 由于当m[i][j]为1、2、3使都不能继续前进
                * 所以此时直接返回false
                * */
                return false;
            }
        }
    }



}



