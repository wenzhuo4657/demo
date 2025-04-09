package cn.wenzhuo4657.com.si;

public class dataStructure {
    /*
     *int [][] arr:将要转换的数组
     * b ：数组中无意义的值
 * @param null
     * @author long
     * @create 2023/6/4
     * @ explain      将一个数组转换为稀疏数组
     **/

    public  int[][]  conversionArr(int [][] arr,int b){
        int [][] arrs;
        //1.确定稀疏数组的列
        int cont=0;
        for (int []arr1 :arr){
            for (int a:arr1){
                if (a!=b){
                    cont++;
                }
            }
        }
//2.确定稀疏数组
        arrs=  new int[3][cont];
        cont=0;
       for (int i=0;i<arr.length;i++){
           for (int j=0;i<arr[0].length;j++){
               if (arr[i][j]!=b){
                   cont++;
                   arrs[cont][0]=i;
                   arrs[cont][1]=j;
                   arrs[cont][2]=arr[i][j];
               }
           }
       }
        
        return  arrs;


    }


    public static void main(String[] args) {




    }



}


//数组实现队列，（非环形）
 class  Arrayqueue{
    private int Max;//表示队列长度+1
    private int font;//表示队列头部的前一个位置
    private int real;//表示队列的尾部
    private  String [] arr;//实现队列结构的数组


    public Arrayqueue(int max) {
        Max = max;
        this.font = -1;
        this.real = -1;
        /*
        * 由于在数组存取操作结束之后，即退出函数，且为保证存取之后指向与存取位置相同，
        * 所以变化存取数组指向的操作在存取数组元素操作之前，所以需要将指向设为前一个下标
        * */
        arr=new String[Max];
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
    public  void add(String a){
        if(isfull())
        {
           throw new   RuntimeException("数组已经被填满，无法继续添加");
        }
        real++;
        arr[real]=a;

    }
    //取
    public  String get(){
        if (real==font+1){
            throw new RuntimeException("数据被取完了");
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
//数组实现队列，（环形）

class ArrayQueue_Ring{
    private int front;//表示队列头部的位置
    private int rear;//表示队列尾部的后一个位置
    private int Max;//表示队列的长度+2
    private  int[] arr;//储存环形队列的数组

    public ArrayQueue_Ring(int max) {
        Max = max;
        front=0;
        rear=0;
        arr=new int[max];
    }
    //判断队列是否满了
    public boolean isfull(){
        if ((rear+1)%Max==front){
            return  true;
        }else{
            return  false;
        }
    }
    //判断队列是否为空
    public  boolean isEmpty(){
        if (rear==front){
            return true;//此时为空
        }else {
            return  false;//此时为非空
        }}

    //获取有效数据的个数
    public  int ValidData(){
        return  (rear+Max-front)%Max;//这里的Max是为了保证在front>rear时依旧为正，可以正确进行求余操作
    }

    //存
    public  void add(int a){
        if (isfull()){
            throw new RuntimeException("队列满了，不能添加了");
        }
        arr[rear]=a;
        rear=(rear+1)%Max;
    }
    //取
    public  int get(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空，无法继续拿出");
        }
        int a=arr[front];
        front++;
        return  a;
    }

    //打印队列
    public  void print(){
        for (int i=front;i<i+ValidData();i++){
            int ii=i%Max;
            System.out.printf("arr[%d]=%d\t",ii,arr[ii]);
        }
    }

}




