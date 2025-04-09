package cn.wenzhuo4657.com.si2;



import java.util.Arrays;

  /**
     *  des:
   *  贪心策略：
   *  通过ends数组维护一条单向延伸的点，无论是否分叉，其中的点都只能找到一个最终点，不存在时返回自身
   *  每次选择的边必须满足最终点不一致，这意味着只有两种情况边可以添加，
   *  1，一个点在当前点集合中，另一个点不在
   *  2，两个点都不在，
   *  满足上述两个条件之一的情况下保证其权值最小的边加入，
   *  其遍历遍历边集合是根据权值大小，并非已经选中的点延伸，这也是和prim算法不同的点，
   *
   *
     * */
public class Kruskal{


    public static void main(String[] args) {
        char [] dot={'A','B','C','D'};
        int  [][]yers= {
                {10000, 5,10,15 ,10000},
                {10000, 10000, 11,10000},
                {20, 10000, 10000,10000},
                {10000,10000,100000,10000,10000}
        };
        mgrap a=new mgrap(dot.length,dot,yers);
        MinTre aa=new MinTre(a);
        System.out.println(aa.ret('C'));
        aa.getsides();
        System.out.println(aa.m);

        for (int i=0;i<aa.m;i++){
                System.out.println(aa.Sides[i]);
        }
        aa.sortSide();
        System.out.println("=========");
        for (int i=0;i<aa.m;i++){
                System.out.println(aa.Sides[i]);
        }

        aa.kruskal();


    }
}

//最小生成树，可解决最短路径问题
class MinTre{
    mgrap HH;
    int[] [] MinTree;//最小生成树
    int n;//点的数量
    char [] Dot;//点的值
    Side[] Sides;//边的数组
    int m=0;//边的数量


    Side []  Side;



    public MinTre(mgrap HH) {
        this.HH = HH;
        MinTree =new int[HH.n][HH.n];
        Dot= HH.Dot;
        n= HH.n;
        Sides= HH.Sides;
        m=HH.m;
        /*
         * 由于图和最小生成树点的数量和点的值一样，所以此处指向同一片地址野可以
         * */

    }


    public void showMgraph(){

        HH.showMgrap();
    }

    public void sortSide(){
        HH.sortSide();
    }

    public int ret(char a){
         return HH.ret(a);
    }

    public void getsides(){
        HH.getsides(HH.Yers);
        this.m= HH.m;//更新边的数量
    }


    public void kruskal(){
        int index = 0;                 // 表示最后结果数组的索引（递增）
        int[] ends = new int[m]; // 用于保存“已有最小生成树”中的每个顶点的终点对应终点在生成树的终点，
        // 创建结果数组：保存最后的最小生成树
        Side[] resultEdges = new Side[m];

        // 获取图中所有的边的集合
        getsides();
        System.out.println("图的边的集合=" + Arrays.toString(Sides) + " 共"+ Sides.length);

        // 按照边的权值大小进行排序(从小到大)
        sortSide();

        // 遍历edges 数组，将边添加到最小生成树时，判断准备加入的边是否形成回路，若没有则加入到 resultEdges，有则不加入
        for (int i = 0; i < m; i++) {
            // 获取第i条边的第一个顶点（起点）
            int p1 = ret (Sides[i].star);// p1
            // 获取第i条边的第二个顶点（终点）
            int p2 = ret (Sides[i].end);  // p2

            // 获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd (ends, p1);
            // 获取p2这个顶点在已有最小生成树中的终点
            int n = getEnd (ends, p2);
            // 判断是否构成回路
            if (m != n) {// 没有构成回路
                ends[m] = n;   //即便分叉，这里的最终点也被替换了最新加入的边的终点，
                resultEdges[index++] = Sides[i];// 一条边加入到最终数组中 resultEdges
            }
        }

        // <E,F> <C,D> <D,E> <B,F> <E,G> <A,B>
        //统计并打印 "最小生成树", 输出  resultEdges
        System.out.println("最小生成树为");
        for (int i = 0; i < index; i++) {
            System.out.println (resultEdges[i] );
        }
    }
    public int getEnd(int [] ends,int i){
        //由于最小生成树特点，
//        由于end数组的特点，分叉时，其分叉的末梢只会有一个末端只能找到0，这意味着，即时分叉，其树中节点依旧只能找到一个最终节点。
//        不断向其中添加的，是起点和终点，在其中找到的最终点，其连续的单向延伸依旧只有一条，在ends数组中并未分叉
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

}



//图：使用邻接矩阵表示
class mgrap{
    int n;//节点个数
    char Dot[];//储存各个节点的值
    int[][] Yers;//邻接矩阵
    Side[] Sides;
    int m=0;

    public mgrap(int n, char[] dot, int[][] yers) {
        this.n = n;
        Dot=new char[dot.length];
        Yers=new int[yers.length][yers.length];
        for (int i=0;i< dot.length;i++){
            Dot[i]=dot[i];
            for (int j=0;j<yers.length;j++){
                Yers[i][j]=yers[i][j];
            }
        }
        Sides=new Side[n*2];
        /*
         * 注意：传入数组传的是地址，此处避免了Yers、yers和dot、Dot指向同一片数据空间
         *
         * */
    }
    public void showMgrap(){
        for (int i=0;i<Yers.length;i++){
            for (int j=0;j< Yers.length;j++){
                System.out.printf("%10d",Yers[i][j]);
            }
            System.out.println();
        }
    }
    /*
     * @Author wenzhuo4657
     * @Description
     给存储边的数组排序
     *
     * @return
     **/
    public void  sortSide(Side []  sides){
        if (sides.length==0){
            throw new RuntimeException("边数组为空");
        }
        for (int i=0;i<m;i++){
            for (int j=i+1;j< m;j++){
                if (sides[j].width<sides[i].width){
                    Side  temp=sides[i];
                    sides[i]=sides[j];
                    sides[j]=temp;
                }
            }

        }
    }

    public void  sortSide(){
        if (this.Sides!=null){
            sortSide(this.Sides);
        }
    }
/*
 * @Author wenzhuo4657
 * @Description
 * @return
 *   i；返回对应的下标
 * -1：没找到
 **/
    public int ret(char a){
        for (int i=0;i< Dot.length;i++) {
            if (Dot[i]==a){
                return i;
            }
        }

        return -1;

    }

/*
 * @Author wenzhuo4657
 * @Description
 *
 * @return
 **/
    public void getsides(int[][] Yers){
        m=0;
        if (Yers==null){
            return;
        }

        for (int i=0;i< Yers.length;i++){
            for (int j=i+1;j< Yers.length;j++){
                if (Yers[i][j]<10000){
                    Sides[this.m]=new Side(Dot[i],Dot[j],Yers[i][j]);
                    m++;
                }

            }
        }

    }


}


class Side{
    char star ;
    char end;
    int width;

    public Side(char star, char end, int width) {
        this.star = star;
        this.end = end;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Side{" +
                "star=" + star +
                ", end=" + end +
                ", width=" + width +
                '}';
    }
}





