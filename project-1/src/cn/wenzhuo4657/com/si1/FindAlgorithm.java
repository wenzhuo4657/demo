package cn.wenzhuo4657.com.si1;

import javafx.stage.DirectoryChooser;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class FindAlgorithm {
    public static void main(String[] args) {
        int []aa={1,2,3,4,5,5,5,6};
        ArrayList<Integer> i= dd1.DichotomousAlgorithm(aa,0,7,7);
        System.out.println("aa:"+i);

    }
}
class  dd1{
//    (1 二分查找   ：可查找多个相同的数字的序号
//    注意：该算法仅仅适用于有序数组

    public  static ArrayList DichotomousAlgorithm(int []arr,int left,int right,int target){
//        结束递归的条件
        if(left>right){
            return new ArrayList<>();
        }


        int mid=(left+right)/2;
        int midNum=arr[mid];
        if (target>midNum){
           return DichotomousAlgorithm(arr,mid+1,right,target);
        }else if (target<midNum){
           return DichotomousAlgorithm(arr, left, mid-1, target);
        }else {
            int temp=mid-1;
            ArrayList<Integer> Targets=new ArrayList<Integer>();
            while (!(temp<0||arr[temp]!=target)){
                Targets.add(temp);
                temp--;
            }
            temp=mid;
            while (!(temp>right||arr[temp]!=target)){
                Targets.add(temp);
                temp++;
            }
            return Targets;
        }


    }
}




























