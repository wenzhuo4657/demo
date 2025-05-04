package cn.wenzhuo4657.Round2.sort;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/14
 * @description:  对插入排序的改进
 */
public class ShellSort {

    /**
     *  @author:wenzhuo4657
        des: 演示插入排序
    */
    public  static  void example(int[] arr){
        int i,j,num;
        for( i=1;i<arr.length;i++){
            num=arr[i];//插入数据： arr[i],插入目标： arr[0,i-1]
            j=i-1;
            while (j>=0&&arr[j]>num){//j指向当前数据，通过该条件判断是否需要向后移
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=num;//值得注意的是，j+1永远指向可以填充的位置，最初指向插入数据的坐标。
        }
    }


    /**
     *  @author:wenzhuo4657
        des: 希尔排序
     其实和归并排序有点像，只不过归并排序是通过递归分组从根部产生有序数组然后逐步有序合并，
    而希尔排序则是通过步长分组，逐渐减小步长排序数组。，
    且注意，每次排序实际上是在部分有序的基础上排序，一定要讲的话，则是说上一次排序使某些元素相对位置变得有序，因此本次排序变得容易得多
    */

    public  static  void shellsort(int[] arr){
        int h=arr.length;
        while (true){
            h=h/2;
            if(h==0){
                break;
            }

//            根据步长进行插入排序，核心问题在于这样做会优化插入排序的原因-----步长所区分的数列会局部有序
//            同时，这样排序的时间复杂度难以分析
            for (int i=h;i< arr.length;i++){
                int j=i;
                int m=arr[j];
                while (j-h>=0&&arr[j-h]>m){
                    arr[j]=arr[j-h];
                    j-=h;
                }
                arr[j]=m;

            }
        }


    }





}
