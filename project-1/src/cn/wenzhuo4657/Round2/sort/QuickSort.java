package cn.wenzhuo4657.Round2.sort;

import cn.wenzhuo4657.Round2.utils.Utils;

import java.lang.reflect.Method;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/13
 * @description:
 */
public class QuickSort {



    /**
     *  @author:wenzhuo4657
        des:  错位交换处理基准数据，最终使其变成两个区间的边界
     */
    public static void example(int[] arr, int left, int right) {
        if (left >= right) {//越界处理
            return;
        }
        int l = left;
        int r = right;

        int mid = arr[l];//1，作为基准，

//        2,错位处理，解决了基准数据移动，即便是极端情况下，也会由于while循环条件只会到达l==r,而这个位置的交换是无效的，最后再将错位的arr[l]填充
//        使基准数据也参与到排序中变动位置。
        while (l < r) {

            while (l < r && arr[r] >= mid) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] < mid) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = mid;

        example(arr, left, l-1);

        example(arr, l+1, right);
    }

    /**
     *  @author:wenzhuo4657
        des:
     将基准设置为中间坐标，而非边界，这种情况下，不用使用错位处理，在双指针移动时会自动将其排序
     最终会将基准尽量交换到中间
    */
    public static  void example2(int [] arr,int left,int right){
        int l=left;
        int r=right;

        int pivot=arr[(l+r)/2];
        while (l<r){
            while (l<r&&arr[l]<pivot){
                l++;
            }//找到大于中间位置的数
            while (l<r&&arr[r]>pivot){
                r--;
            }//找到小于中间位置的数

            if (l==r){
                l++;
                r--;
                break;
            }

            //交换两个位置的数据
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

// 有两个作用 ，1，将相等的值尽量向中间移动，（因此下一左边交换的一定是l,而右边）
            if (arr[l]==pivot&&arr[r]==pivot){
                r--;
                l++;

            }
        }

        //进行递归
        /*
         *注意：再次传入数据的范围保证了不确定排序区域的再次排序
         * 也就是说当递归结束时，返回数组的所有元素都满足上面的循环体
         * 对其进行左递归和右递归，
         * */
        if (left<r){
            example2(arr,left,r);
        }
        if (right>l){
            example2(arr ,l,right);
        }
    }


    public static void main(String[] args) throws Exception {
        int[] arr=new int[11];
        Utils.generateIntArray(arr);
        Class<QuickSort> quickSortClass = QuickSort.class;
        Method example = quickSortClass.getMethod("example", int[].class, int.class, int.class);
        QuickSort quickSort = new QuickSort();
        Object[] arg=new Object[3];
        arg[0]=arr;
        arg[1]=0;
        arg[2]=arr.length-1;
        Utils.testInt(quickSort,example,arg);

    }


}

