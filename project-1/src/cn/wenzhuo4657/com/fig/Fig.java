package cn.wenzhuo4657.com.fig;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;


public class Fig {//无向图
    int[][] arr;//邻接矩阵
    ArrayList<String> list;//节点的名字
    boolean[] ll;//该节点是否被访问
    int side;//图中边的个数

    public static void main(String[] args) {

        String [ ]  a={"北京","上海","深圳","大连","郑州","南通"};
        Fig as=new Fig(6,a);
        as.addside("北京","上海");
        as.addside(a[0],a[2]);
        as.addside(a[1],a[2]);
        as.addside(a[1],a[5]);
        as.addside(a[3],a[5]);
        as.addside(a[3],a[4]);
        as.addside(a[4],a[5]);
        as.print_arr();
        System.out.println("DFS遍历");
        as.DFS();
        System.out.println("\nBFS遍历");
        as.BFS();


        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }

    public Fig(int n, String[] nameS) {
        this.arr = new int[n][n];
        for (int i=0;i< arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j]=0;
            }
        }
        list = new ArrayList<>();
        ll = new boolean[n];
        for (int i=0;i< ll.length;i++){
            ll[i]=false;
        }
        side = 0;
        for (String a : nameS) {
            list.add(a);
        }
    }

    //添加边
    public void addside(String place1, String place2) {
        int dot1=-1;
        int dot2=-1;
        for (int i=0;i<list.size();i++){
            if (list.get(i)==place1){
                dot1=i;

            }
            if (list.get(i)==place2){
                dot2=i;

            }
        }
        if (dot1==-1||dot2==-1){
            return;
        }
        arr[dot1][dot2] = 1;
        arr[dot2][dot1] = 1;
        side++;
    }


    public  void print_arr(){
        for (int[] a:arr){
            System.out.println(Arrays.toString(a));
        }
    }
    /*
     * @Author wenzhuo4657
     * @Description
     * 找到当前节点的第一个邻接节点。并返回
     * @return
     * i :邻接节点
     * -1：表示没有其他邻接节点
     **/
    public int Find(int index){
        if (index<0||index>= arr.length){
            return -1;
        }
        for (int i=1;i<arr[index].length;i++){
            if (arr[index][i]==1){
                return i;
            }
        }
        return -1;
    }
    /*
     * @Author wenzhuo4657
     * @Description
     * 找到当前节点的下一个邻接节点并返回
     * @return
     * i :下一个邻接节点
     * -1：表示没有其他邻接节点
     **/

    public int FindNext(int  index,int i){
        for (int j=i+1;j<arr[index].length;j++){
            if (arr[index][j]==1){
                return j;
            }
        }
        return -1;
    }
//将一个节点的所有边遍历，并保证不输出重复边
    public void DFS(int index){
        System.out.print(list.get(index)+"\t");
        ll[index]=true;
        int m=Find(index);

        while (m!=-1){
            if (!ll[m]){
                DFS(m);
            }
            m=FindNext(index,m);
        }
    }
    public void DFS(){
        if (list.size()<1){
            System.out.println("节点数量低于1，建议手动");
            return;
        }
        for (int i=0;i<list.size();i++){
            if (ll[i]!=true){
                DFS(i);
            }
        }

        //遍历完成，对ll数组(判断节点是否访问过的数组)进行重置
        for(int i=0;i< ll.length;i++){
            ll[i]=false;
        }
    }


    public void BFS(boolean[] ll,int a){
        int m;//队列头节点
        int n;//邻接节点
        queque as=new queque(arr.length*3);
        System.out.print(list.get(a)+"\t");
        ll[a]=true;
        as.add(a);
        while (!as.isEmpty()){
            m= as.get();
            n=Find(m);
            while (n!=-1){
                if (!ll[n]){
                    System.out.print(list.get(n)+"\t");
                    ll[n]=true;
                    as.add(n);
                }
                n=FindNext(m,n);
            }
        }
    }
    public void BFS(){
        for (int i=0;i< arr.length;i++){//注意;无向图中可能存在孤立的点以及两部分图无关联的图
            if (!ll[i]){
                BFS(ll,i);
            }
        }
    }

}
class  queque{
    private int Max;//表示队列长度+1
    private int font;//表示队列头部的前一个位置
    private int real;//表示队列的尾部
    private  int [] arr;//实现队列结构的数组


    public queque(int max) {
        Max = max;
        this.font = -1;
        this.real = -1;
        /*
         * 由于在数组存取操作结束之后，即退出函数，且为保证存取之后指向与存取位置相同，
         * 所以变化存取数组指向的操作在存取数组元素操作之前，所以需要将指向设为前一个下标
         * */
        arr=new int[Max];
    }

    public boolean isEmpty(){
        if (font<real){
            return false;
        }else {
            return true;
        }
    }
    //    判断数组元素是否被填满
    public Boolean isfull(){
        if (real==Max-1){
            return true;
        }else {
            return false;
        }
    }

    //    存
    public  void add(int a){
        if(isfull())
        {
            throw new   RuntimeException("数组已经被填满，无法继续添加");
        }
        real++;

        arr[real]=a;

    }
    //取
    public  int get(){
        if (real<=font){
            return -1;
            //throw new RuntimeException("数据被取完了");
        }
        font++;

        return  arr[font];
    }

    //打印队列
    public  void pppp(){
        if (font>=real){
            throw new RuntimeException("当前队列没有数据");
        }
        for (int i=font;i<real;){
            i++;
            System.out.printf("arr[%d]=%s\n",i,arr[i]);
        }
    }

}







