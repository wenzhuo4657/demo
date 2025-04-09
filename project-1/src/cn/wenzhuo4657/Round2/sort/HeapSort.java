package cn.wenzhuo4657.Round2.sort;

import java.util.Arrays;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/17
 * @description: 堆排序
 *  利用树结构进行的排序
 *  大顶堆： 父节点均大于等于其左右节点的值
 *  小顶堆：父节点均小于等于其左右节点的值
 *
 *  且注意，这样的树即便使用顺序二叉树扁平化为数组处理，也依旧不能保证同层次节点的大小关系，只是像快速排序那样，保证了不同区间内的大小关系。
 */
public class HeapSort {

/**
 *  @author:wenzhuo4657
    des:
 大顶堆排序思想： 利用根节点最大值的特点，每次排序找到当前数组范围内的最大值，
        for(int i=arr.length;i>0;i--){
           将根节点和末尾节点交换
          将arr[0,i]范围,最大的值转移到根节点处
       }

 上述排序最关键的一点即，我们如何将一个树变为大顶堆结构？
 1，基于顺序二叉树的扁平化处理，使位置交换效率达到最高
 2，假设我们传入的是一个大顶堆，那么如何将这个根节点找到适合他的位置呢？  答：只要找到某个节点的左右节点都不大于这个根节点即可
*/


/**
 *  @author:wenzhuo4657
    des:  要将root下沉到合适的地方，且需要注意，以root为跟节点的这个子树（可能是0，就是这棵树本身），除了根节点以外，都符合大顶堆定义。
         arr:顺序二叉树，
         root: 某个节点，这里将其视为数组在该子树中找到合适位置的节点
         length;排序范围
*/

public  static  void heap1(int arr[] ,int root,int length){
    int temp=arr[root];//临时存储根节点

    for (int k=root*2+1;k<length;k=k*2+1){
        if (k+1<length&&arr[k]<arr[k+1]){//1,找到左右较大的那个
            k++;
        }
        if (temp<arr[k]){//判断三元组 节点root和节点root的左右节点的最大值
            arr[root]=arr[k];//这一步相当于是移位交换，交换目标为，root和k
            root=k;//不断更新root节点，
        }else {
            break;
        }
    }
    arr[root]=temp;//完成下沉

}

    public static void heap2(int []arr){
        int temp=0;
//转换顺序二叉树为大顶堆，arr.length/2-1==（(arr.length-1)末尾节点-1）/2 ，从最底层开始逐渐完成大顶堆定义，换言之，他的每一个子树都符合大顶堆。
        for (int i=arr.length/2-1;i>=0;i--){
            heap1(arr,i, arr.length);
        }
        System.out.println(Arrays.toString(arr));

        //堆排序
        for (int j= arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            heap1(arr,0, j);
        }
    }




}
