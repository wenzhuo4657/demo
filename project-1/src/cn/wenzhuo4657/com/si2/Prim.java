package cn.wenzhuo4657.com.si2;

import java.util.Arrays;

  /**
     * des:
   *  核心目标：加权值之和但包含所有点，即最小生成树
   *  贪心策略，
   *  起点已访问，终点未访问的最短边
   *  该策略同时保证了不会造成回路
     * */
public class Prim {
    public static void main(String[] args) {
        char [] dot={'A','B','C','D','E','F','G'};
        int  [][]yers={
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        Mgraph a=new Mgraph(dot.length,dot,yers);
        Mintree aa=new Mintree(a);
        aa.showMgraph();
        aa.getMintree('A');

    }
}

//最小生成树，可解决最短路径问题
class Mintree{
    Mgraph HH;
    int[] [] Mintree;//最小生成树，也是图，但这里是有向图
    int n;//点的数量
    char [] Dot;//点的值


    public Mintree(Mgraph HH) {
        this.HH = HH;
        Mintree =new int[HH.n][HH.n];
        Dot= HH.Dot;
        n= HH.n;
        /*
        * 由于图和最小生成树点的数量和点的值一样，所以此处指向同一片地址野可以
        * */

    }


    public void showMgraph(){
        HH.showMgraph();
    }
    public void getMintree(char v){
        int[] vid=new int[n];//标记节点是否被访问过
        int min=10000;//记录权值最小的边
        int i=0;//min所代表边的坐标
        int j=0;


        for (int s=0;s<Dot.length;s++){
            if (v==Dot[s]){
                vid[s]=1;//找到v所在的起始点并标记
                break;
            }
            if (s==Dot.length-1){
                return;//没找到对应的起始点
            }
        }


        for (int k=1;k<Dot.length;k++){//循环n-1次，

            for (int m=0;m<HH.Yers.length;m++){//m表起点，n表终点
                for (int n=0;n<HH.Yers.length;n++){
                    if (vid[m]==1&&vid[n]==0&&HH.Yers[m][n]<min){
//此处保证了prim算法不生成环的子图，
//                        prim算法每次添加边的条件为，1，终点没有访问过，2，边的权重相对最小
//                        且注意，如果成环，一定会存在起点和终点二次访问，即添加终点和起点都访问过的边，
//                        反之，如果不添加，则不会成环，prim算法就是基于此处推论得出的
                        min=HH.Yers[m][n];
                        i=m;
                        j=n;
                    }
                }
            }
            vid[j]=1;

            System.out.println(Dot[i]+"==>"+Dot[j]+"权值为"+ HH.Yers[i][j]);
            Mintree[i][j]=HH.Yers[i][j];
            min=10000;
            i=0;
            j=0;

        }
    }
}

//图：使用邻接矩阵表示
class Mgraph{
    int n;//节点个数
    char Dot[];//储存各个节点的值
    int[][] Yers;//邻接矩阵

    public Mgraph(int n, char[] dot, int[][] yers) {
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





}
