package cn.wenzhuo4657.com.si2;

import java.util.Arrays;
import  java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        char [] dot={'A','B','C','D','E','F','G'};
        int  [][]yers={
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10-000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        grap a=new grap(dot.length,dot,yers);
        a.Dij(6);

        System.out.println();



    }






}


//图：使用邻接矩阵表示
class grap{
    int n;//节点个数
    char Dot[];//储存各个节点的值
    int[][] Yers;//邻接矩阵

    public grap(int n, char[] dot, int[][] yers) {
        this.n = n;
        Dot=new char[dot.length];
        Yers=new int[yers.length][yers.length];
        for (int i=0;i< dot.length;i++){
            Dot[i]=dot[i];
            for (int j=0;j<yers.length;j++){
                Yers[i][j]=yers[i][j];
            }
        }
            /*
         * 注意：传入数组传的是地址，此处避免了Yers、yers和dot、Dot指向同一片数据空间
         *
         * */
    }
    public void showMgraph(){
        for (int i=0;i<Yers.length;i++){
            for (int j=0;j< Yers.length;j++){
                System.out.printf("%10d",Yers[i][j]);
            }
            System.out.println();
        }
    }

    Mintr D;
    /*
     * @Author wenzhuo4657
     * @Description
     * 通过维护isDistance和 Find_pre数组来得到最短路径
     *
     * @return
     **/
    public void Dij(int index){
        D = new Mintr(n, index);
        uptaq(index);
        for (int i=1;i<n;i++){
            index=D.uptaindex();
            uptaq(index);
        }

        D.showDij();

    }

/*
 * @Author wenzhuo4657
 * @Description
 * 以index为节点进行广度遍历，来维护isDistance和 Find_pre数组
 * 根本目的在保证以index出发的每条路径都最短
 * @return
 **/
    private void uptaq(int index){
        int len=0;
        for (int j=0;j<Yers[index].length;j++){

            len=D.getDistance(index)+Yers[index][j];
            if (!D.isVis(j)&&len<D.getDistance(j)){
                /*
                假设G为出发顶点
                * 此处len=G->index+index->j;
         D.isDistance[j]=G-j
                （1，且不必担心表示（没有边的值10000），isDistance数组除去出发顶点本身默认值为
                10000，不会将没有连线的节点更新
                （2，且需注意：此处更新的D-j的最短路径，G-index-j作为小路进行比较


                ！！！！：注意：该处并没有将j节点更改为已经访问过
                * */

                D.upta_pre(j,index);
                D.upta(j,len);
            }
        }

    }




}


class  Mintr{
    int [] isVisit;//判断节点是否被访问过
    int [] isDistance;//出发顶点到各个点的最短距离，
    int []  Find_pre;//记录当前节点的上一个节点的下标

    public  void showDij(){
        System.out.println("int [] isDistance://出发顶点到各个点的最短距离");
        for(int i=0;i<isDistance.length;i++){
            System.out.println("出发顶点到6"+i+"的最短距离为"+isDistance[i]);
        }
        System.out.println(" int []  Find_pre;//记录当前节点的上一个节点的下标");
        for(int i=0;i<Find_pre.length-1;i++){
            System.out.println(i+"->"+Find_pre[i]);
        }
    }


    public Mintr(int n,int index) {
        isVisit=new int[n];
        isDistance=new int[n];
        Find_pre=new int[n];
        Arrays.fill(Find_pre,10);
        Arrays.fill(isDistance,10000);
        /*
        * 10,10000表示无的意思
        * */
        isVisit[index]=1;
        isDistance[index]=0;
    }
    /*
     * @Author wenzhuo4657
     * @Description
     * 判断某个顶点是否被访问过
     * @return
     * false：没有被访问过
     * true：被访问过
     **/
    public boolean isVis(int index){
        if (isVisit[index]==0){
            return false;
        }else {
            return true;
        }
    }
/*
 * @Author wenzhuo4657
 * @Description
 * 更新出发顶点当当前顶点的距离
 * @return
 **/
    public void upta(int index,int len){
        isDistance[index]=len;
    }
/*
 * @Author wenzhuo4657
 * @Description
 * 更新index的前驱节点
 * @return
 **/
    public void upta_pre(int index,int pre){
        Find_pre[index]=pre;
    }
/*
 * @Author wenzhuo4657
 * @Description
 * 返回当前节点到出发节点的距离
 * @return
 **/
    public int  getDistance(int index){
        return isDistance[index];
    }


/*
 * @Author wenzhuo4657
 * @Description
 * 遍历isDistance数组，得到距离出发顶点最短且没有被访问过节点，
 * 将其标记访问并返回
 * @return
 *
 **/
    public  int uptaindex(){
        int min=10000,intdex=0;
        for (int i=0;i<isDistance.length;i++){
            if (!isVis(i)&&getDistance(i)<min){
                min=getDistance(i);
                intdex=i;
            }
        }

        isVisit[intdex]=1;
        return intdex;
    }



}