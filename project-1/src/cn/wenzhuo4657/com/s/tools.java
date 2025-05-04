package cn.wenzhuo4657.com.s;

import jdk.jfr.events.FileReadEvent;


import java.io.*;

public class tools {
    //打印二进制

    public static void print(int a) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((a & (1 << i)) == 0 ? 0 : 1);
        }
        System.out.println("");


    }




    /*
    * 文件拷贝函数：按行读取，将文件对象a按行复制到b
    * 注意：不要操作二进制文件，可能会导致文件损坏
    * */

    public  static  void Filecopy(FileReader a,FileWriter b){
        BufferedReader BI=null;
        BufferedWriter Bo=null;



        try {
            BI=new BufferedReader(a);
            Bo=new BufferedWriter(b);
            String c;

            while ( (c= BI.readLine())!=null){
                Bo.write(c);
                Bo.newLine();//插入一个换行，保证按行写入

            }


            System.out.println("拷贝完成");
        } catch (IOException e) {
            System.out.println("拷贝失败");
            throw new RuntimeException(e);
        } finally {
            if (BI != null) {
                try {
                    BI.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (Bo != null) {
                try {
                    Bo.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }
    /*
    * 文件拷贝函数：指定每次读取字节大小
    *
    * a表示将要拷贝函数的路径
    * b表示拷贝数据的目标的文件
    * c表示拷贝文件是每次读取数据的大小
    *（注意：如果b路径下没有指定文件，根据FileOutputStream类的特点将会创建
    * */

public  static void Filecopy(String a,String b,int c) throws IOException {
    FileInputStream filecopy=new FileInputStream(a);
    FileOutputStream filecopy_1=new FileOutputStream(b);



    try {

        byte [] cs=new byte [c];
        int read;
        while((read=filecopy.read(cs))!=-1){
            filecopy_1.write(cs,0,read);//必须指定写入数组的大小，

        }
        System.out.println("拷贝完成");
    } catch (IOException e) {
        System.out.println("拷贝失败");
        throw new RuntimeException(e);
    } finally {
        filecopy_1.close();
        filecopy.close();

    }

}

 /*
 *
 * 二分法查找小于num的数在有序数组arr中的最左端的位置，如果有则返回i，如果没有返回-1
 *
 *
 * */
    public  static  int Find(int num ,int [] arrs){

        if(arrs==null||arrs.length<=1){
            return -1;
        }//判断输入是否非法
        int L=0;//用于表示比较区间的最左端
        int H=arrs.length-1;//比较区间最右端
        int   ans=-1;//表示目标数据的位置序号
        while (L<=H){
            int mi=(L+H)/2;//表示当前比较区间的中位
            if(arrs[mi]<=num){
                H=mi-1;//更新最右端端位置
                ans=mi;

            }else{
                L=mi+1;//更新最左端位置
            }
        }
        return  ans;
    }


    //获取当前计算的cpu核心数，

public  void get_cpu(){
        Runtime tun =Runtime.getRuntime();
        int cpus = tun.availableProcessors();
        System.out.println("当前计算机的cpu核心数为："+cpus);
    }
    /*生成随机数组
     * a1表示随机数组的最大长度
     * b1表示随机数组元素的最大值
     *
     * */
    public static int[] arrs(int a1, int a2) {
        int a = (int) Math.random() * a1;//生成随机数组长度
        int arr[] = new int[a1];
        for (int i = 0; i < a1; i++) {
            arr[i] = (int) Math.random() * a2;//生成随机数组值
        }
        return arr;
    }

}


//对数期(未完成
class Logarithmic<t, s> {
    t algorithm1;
    s algorithm2;

    public Logarithmic(t algorithm1) {
        this.algorithm1 = algorithm1;
    }

    public Logarithmic(t algorithm1, s algorithm2) {
        this.algorithm1 = algorithm1;
        this.algorithm2 = algorithm2;
    }

    /*
     * a表示实验次数
     * b表示创建随机数组的最大长度
     * c表示创建随机数组值的最大值
     * 注意：创建随机数组是调用自定义方法arrs（）；
     * */
    public void examine(int a, int b, int c) {
        if (algorithm2 == null) {

        }
    }
}
