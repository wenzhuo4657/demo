package cn.wenzhuo4657.com.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class HuffmanTree {
    public static void main(String[] args) {
          String a="The shadow is probably due to I don't know the dream, the illusion of the eyes of the wandering people ";
          byte[] aa=a.getBytes();
        System.out.println("转换前："+aa.length+"字节");
        nod ab=huffmanT(aa);
        con(ab);
        System.out.println(huff);






    }


/*
 * @Author wenzhuo4657
 * @Description
 * 功能：给定一个数组，返回一个赫夫曼树
 * @return
 **/
    public static nod sort1(int [] arr){
        ArrayList ndoes=new ArrayList<nod>();
        for (int i:arr){
            ndoes.add(new nod(i));
        }

        while (ndoes.size()>1){
            Collections.sort(ndoes);
            nod i1=(nod) ndoes.get(0);
            nod i2=(nod) ndoes.get(1);
            nod  i3=new nod(i1.a+ i2.a);
            i3.left=i1;
            i3.right=i2;

            ndoes.remove(i1);
            ndoes.remove(i2);

            ndoes.add(i3);

        }
        return  (nod) ndoes.get(0);
    }


/*
 * @Author wenzhuo4657
 * @Description
 * 将给定字符串数组转化为一个赫夫曼树，
 * @return
 **/
    /*
    * 思路分析
    * （1，根据字符出现次数将数组转化为一个list集合
    * （2，转化为赫夫曼树
    *
    * */
    public  static nod  huffmanT(byte[] a){
        if (a==null||a.length==1){
            System.out.println("请检查传入的字符数组");
            return null;
        }
        ArrayList<nod>  b=new ArrayList<>();
        Map <Byte ,Integer>  bs=new HashMap<>();
        for (byte i:a){
            if (bs.get(i)==null){
                bs.put(i,1);
            }else {
                int cont= bs.get(i);
                bs.put(i,cont+1);
            }
        }
        for (Map.Entry<Byte,Integer> h:bs.entrySet()){
          b.add(new nod(h.getValue(),h.getKey()));
        }

        while (b.size()>1){
            Collections.sort(b);
            nod  m=b.get(0);
            nod  n=b.get(1);
            nod  z=new nod(m.m+ n.m,null);
            z.left=m;
            z.right=n;
            b.remove(m);
            b.remove(n);
            b.add(z);

        }


        return b.get(0);

    }

//    存储赫夫曼表：字符及其路径/赫夫曼编码
    static  Map<Byte,String>   huff=new HashMap<>();
//    暂存叶子节点的路径
    static  StringBuilder  hufs=new StringBuilder();

/*
 * @Author wenzhuo4657
 * @Description
 * a:赫夫曼树的根节点
 * code：0/1，表示向左节点前进或是向右节点前进
 * h：暂存路径
 * 功能：将a节点所代表的赫夫曼树转化为赫夫曼编码表
 * @return
 * 赫夫曼编码表
 **/
    public  static  void con(nod a,String code,StringBuilder  hufs){
        StringBuilder h2=new StringBuilder(hufs.toString());
        h2.append(code);
        if (a!=null){
            if (a.n==null){//该节点并非叶子节点，继续递归寻找
                con(a.left,"0",h2);
                con(a.right,"1",h2);
            }else {
                huff.put(a.n,h2.toString());
            }
        }


        }







//    重载con方法，方便使用，并无实际作用
    public static void con(nod a){
        if (a==null){
            return;
        }

        con(a.left,"00",hufs);
        con(a.right,"01                   ",hufs);
    }




}



//节点类
class nod  implements Comparable<nod> {
    int a;
    int value;
    nod left;
    nod right;


    int m;//字符出现次数
    Byte n;//字符的uncode编码


    public nod(int a) {
        this.a = a;
    }

    public nod(int m, Byte n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public String toString() {

        int n = (byte) this.n;
        return "[nod:" + "m:" + m + "  n:" + (char) n + "]";

    }

    @Override
    public int compareTo(nod o) {
        return this.m - o.m;
    }

    public void print() {
        if (this.n != null) {
            System.out.println(this);

        }
//        if (this.value!=0){
//            System.out.println((char) this.value);
//
//        }
        if (this.left != null) {
            this.left.print();
        }
        if (this.right != null) {
            this.right.print();
        }

    }


}

