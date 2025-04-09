package cn.wenzhuo4657.com.si2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

//骑士周游问题
public class Case8 {

/*
 * @Author wenzhuo4657
 * @Description
 * 找到dot点对象可以向哪几个位置的”方向“行走并返回,
 * @return
 **/
    public static ArrayList<Point> Find(Point dot){
        ArrayList<Point> AA=new ArrayList<>();
        Point p1=new Point();

        if ((p1.x= dot.x-2)>=0&&(p1.y= dot.y-1)>=0){
            AA.add(new Point(p1));
        }
        if ((p1.x= dot.x-1)>=0&&(p1.y= dot.y-2)>=0){
            AA.add(new Point(p1));
        }


        if ((p1.x= dot.x-2)>=0&&(p1.y= dot.y+1)<y){
            AA.add(new Point(p1));
        }if ((p1.x= dot.x-1)>=0&&(p1.y= dot.y+2)<y){
            AA.add(new Point(p1));
        }

        if ((p1.x= dot.x+2)<x&&(p1.y= dot.y-1)>=0){
            AA.add(new Point(p1));
        }if ((p1.x= dot.x+1)<x&&(p1.y= dot.y-2)>=0){
            AA.add(new Point(p1));
        }

        if ((p1.x= dot.x+2)<x&&(p1.y= dot.y+1)<y){
            AA.add(new Point(p1));
        }if ((p1.x= dot.x+1)<x&&(p1.y= dot.y+2)<y){
            AA.add(new Point(p1));
        }


        return AA;

    }
    static  int x=6;
    static  int y=6;
    static boolean [] vis=new boolean[x*y];//判断当前棋子是否走过
    static Boolean DDD=false;//判断是否完成周游

/*
 * @Author wenzhuo4657
 * @Description
 * aa:记录骑士周游的顺序
 * row、col：当前点的坐标
 * step：走过了多少步，用于结束递归
 * @return
 **/
    public static  void stata(int[][ ] aa,int row,int col,int step){

        aa[row][col]=step;
        vis[row*y+col]=true;
        ArrayList<Point> ss=Find(new Point(row,col));//得到当前位置可以向哪些位置前进
        while (!ss.isEmpty()){
            Point a=ss.remove(0);
            if (!vis[a.x*y+a.y]){
                //该if的作用
                //（1，判断该点是否可以进行递归查询
                //（2.当递归成功解决了骑士周游问题时，即使发生回溯也不会进行不必要的递归
                stata(aa, a.x, a.y,step+1);
            }
        }

//某次递归结束时进行判断，如果没有完成任务需要将当前函数内对棋盘的变化消除，而并非置空棋盘
        if (step<x*y&&!DDD){
            aa[row][col]=0;
            vis[row*y+col]=false;
            //假如棋子由A-B-----，那么此处相当于当前位置再B,将棋盘回溯至未选B的A处，也就是上一次递归
        }else {
            DDD=true;
        }


    }

    public static void main(String[] args) {
        int [] [] aa=new int[x][y];
        long star=System.currentTimeMillis();
        stata(aa,0,0,1);
        long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-star));
        for (int i=0;i<aa.length;i++){
            System.out.println(Arrays.toString(aa[i]));
        }
    }
}
