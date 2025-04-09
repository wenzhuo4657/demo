package cn.wenzhuo4657.com.Tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        hero2(arr);
        System.out.println(Arrays.toString(arr));

    }

    /*
     * @Author wenzhuo4657
     * @Description
     * 功能：将i，i的左右节点中最大的数调换的到i
     * 注意：如果传入的是大顶堆二叉树顺序存储的数组，将i为根节点的树中最大的数调换到i
     * @return
     **/
    public static void hero1(int []arr,int i,int lenght){
        int temp=arr[i];
        for (int k=i*2+1;k<lenght;k=k*2+1){
            if (k+1<lenght&&arr[k]<arr[k+1]){
                k++;
            }
            if (temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;

    }
    public static void hero2(int []arr){
            int temp=0;

//将数组转为大堆顶结构
//        为何arr.length/2-1是第一个非叶子节点，由于是完全二叉树存储的
            for (int i=arr.length/2-1;i>=0;i--){
                hero1(arr,i, arr.length);
            }
        System.out.println(Arrays.toString(arr));

            //堆排序
        for (int j= arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            hero1(arr,0, j);
        }
    }

}



