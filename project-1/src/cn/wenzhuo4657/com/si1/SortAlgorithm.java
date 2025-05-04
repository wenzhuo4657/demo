package cn.wenzhuo4657.com.si1;


import java.util.Arrays;
public class SortAlgorithm {


    public static void main(String[] args) {

        int [] arr={75,57,2,4,5,574};
        System.out.println("排序前arr"+Arrays.toString(arr));
        jj4.CardinalitySorting(arr);
        System.out.println("排序后arr"+Arrays.toString(arr));
    }
}


class jj{

    //希尔排序：采取的是移位法
    public  static  void shellsort(int [] a){
        int h=a.length;
        while (true){
           h=h/2;
            if (h<=0){
                break;
            }
              /**
                 *  des: 这里使用的是直接插入排序，但在内层for循环中保证了希尔排序分组，其每次插入排序都在其分组内进行。
                 * */
            for (int i=h;i< a.length;i++){
                int j=i;
                int m=a[j];
               while (j-h>=0&&a[j-h]>m){
                   a[j]=a[j-h];
                   j-=h;
               }
               a[j]=m;

            }
        }
    }




    public  static  void BubblingSorting(int [] a){
        for (int i=0;i<a.length;i++){
            for (int j=1;j<a.length-i;j++){
                if (a[j-1]>a[j]){
                    int m=a[j-1];
                    a[j-1]=a[j];
                    a[j]=m;
                }
            }
        }

    }

    public static  void print(int [] a){
        for (int i=0;i< a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
}

class jj2{
 /*
  * @Author wenzhuo4657
  * @Description  快速排序：传入一个一维数组、需要排序的左侧和右侧序号
  * @return  无返回值
  **/
    public static  void QuickSort(int [] arr,int left,int right){
        int l=left;
        int r=right;

        int pivot=arr[(l+r)/2];
        while (l<r){
            while (arr[l]<pivot){
                l++;
            }//找到大于中间位置的数
            while (arr[r]>pivot){
                r--;
            }//找到小于中间位置的数
            if (l>=r){
                break;
            }//结束循环


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
//避免栈溢出：避免下一递归调用中出现走不出循环的现象
        if (l==r){
            l++;
            r--;
        }
//        不是指针碰撞的话，只能是错位，而者都正好碰触到对方的边界而停止

        //进行递归
        /*
        *注意：再次传入数据的范围保证了不确定排序区域的再次排序
        * 也就是说当递归结束时，返回数组的所有元素都满足上面的循环体
        * 对其进行左递归和右递归，
        * */
        if (left<r){
            QuickSort(arr,left,r);
        }
        if (right>l){
            QuickSort(arr ,l,right);
        }

    }

}



class jj3{
    /*
    * 思路分析
    * 1.递归实现分组，
    * 2.在递归调用每一步合并中实现临时数组的由小到大
    * 注意：递归编程依旧属于同步编程，并非异步，在上一个递归调用结束前，先一个递归调用不会开始
    * 注意：递归编程应该从结束编程的调用开始考虑
    * */
    public static   void   MergeSort(int  []arr,int left,int right,int[] temp){
        if (left<right){
           int  min=(left+right)/2;//保证该递归的结束，极限为0、1和7、8时，min取整数得0，使得递归调用结束
            MergeSort(arr, left, min, temp);
            MergeSort(arr, min+1, right, temp);
            //合并调用
            Merge(arr,left,min,right,temp);

        }

    }

    public static void Merge(int[] arr,int left,int min,int right,int [] temp){
        int i=left;
        int j=min+1;
        int t=0;

        System.out.println("left="+left+"\tright"+right);
        //(1)分割数组，按照一定大小进行
//        其结果只会剩下一边数据，按顺序的大于已经复制进temp中的数
        while (i<=min&&j<=right){//这样子填充左右要从递归根部考虑，即两个数字的情况，实现的局部有序，这意味着后续左右两边均是有序数组
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                i++;
            }else {
                temp[t]=arr[j];
                j++;
            }

            t++;
        }

        //(2)将剩余数据依次放到temp数组中，
//        注意：由于递归特点，，以下列两个while只能进去一个·，
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

        //(3)将temp中已经排序的区域复制到arr相同区域中
        t=0;
        int temp1=left;
        while (temp1<=right){
            arr[temp1]=temp[t];
            t++;
            temp1++;

        }




    }

}



class  jj4{
    public  static  void  CardinalitySorting(int [] arr){
//        (1 确定数组中所有数中的最大长度
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }
//        视为数组中数字的最大长度
        int maxLength=(max+"").length();



//       作为桶来临时存储
        int [][] arrs=new  int [10][arr.length];
//        用于记忆每一个桶存了几个数字
        int []  arrsLength=new int[10];



        for ( int i=0,n=1;i<arr.length;i++,n*=10){

//            (2 ,按照对应位的数置于相应的桶中,并记忆相应桶中数的多少
            for(int j=0;j<arr.length;j++){
                int s=arr[j]/n%10;
               arrs[s][ arrsLength[s]]=arr[j];
                arrsLength[s]++;
            }

//            （3 取出相应桶中的数放入数组中
            int index=0;//表示存入原数组的序号
            for(int h=0;h<arrsLength.length;h++){
                if (arrsLength[h]!=0){
                    for (int t=0;t<arrsLength[h];t++){
                        arr[index++]=arrs[h][t];
                    }
                    arrsLength[h]=0;
                }
            }

        }
    }
}

