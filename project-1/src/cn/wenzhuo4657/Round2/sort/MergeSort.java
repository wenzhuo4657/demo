package cn.wenzhuo4657.Round2.sort;

import cn.wenzhuo4657.Round2.utils.Utils;

import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/13
 * @description:
 */
public class MergeSort {

    /**
     *  @author:wenzhuo4657
        des: 归并排序
     arr: 排序数组
     [left,right]: 排序范围
     temp: 临时数组，用于存储临时的局部排序结果，且注意，每次局部排序都会从i=0开始填充，这意味着覆盖上一次排序的结果。
    */
    public static void example(int  []arr,int left,int right,int[] temp){

//        该函数主要用于实现递归调用的流程

        if(left<right){
            int min=(left+right)/2;
            example(arr,left,min,temp);
            example(arr,min+1,right,temp);

            merge(arr,left,min,right,temp);//基于归并排序的递归流程，该方法所得到的数组均是局部有序，极限情况，为两个元素的区间，例如 [0,1]
        }


    }

    /**
     *  @author:wenzhuo4657
        des: 该排序生效的数组必须是局部有序的数组，或者说，[left,min]升序，[min+1,right]升序
    */
    private static void merge(int[] arr, int left, int min, int right, int[] temp) {
        int i=left;
        int j=min+1;
        int t=0;
//        1,两个有序区间[left,min] [min+1,right]
        while (i<=min&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                i++;
            }else {
                temp[t]=arr[j];
                j++;
            }
            t++;
        }


//       2, 基于上述while循环特点，最终只剩下一边数据没有填充，并且由于区间局部有序可知，此时省下的数据可以直接顺序填充
        while (i<=min){
            temp[t]=arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }

//        3,填充完毕，将结果复制到原本数组的区间
        t=0;
        for(int h=left;h<=right;h++){
            arr[h]=temp[t];
            t++;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        int[] arr=new int[11];
        Utils.generateIntArray(arr);

        Class<MergeSort> mergeSortClass = MergeSort.class;
        Method example = mergeSortClass.getMethod("example", int[].class, int.class, int.class,int[].class);
        MergeSort mergeSort = new MergeSort();
        Object[] arg=new Object[4];
        arg[0]=arr;
        arg[1]=0;
        arg[2]=arr.length-1;
        arg[3]=new int[arr.length];
        Utils.testInt(mergeSort,example,arg);



    }
}
