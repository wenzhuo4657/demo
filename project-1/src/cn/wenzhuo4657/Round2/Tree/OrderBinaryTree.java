package cn.wenzhuo4657.Round2.Tree;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/17
 * @description: 顺序二叉树
 *
 * 本质上是利用完全二叉树结构的推论，无论实际如何它的编号一定是按照完全二叉树的编号
 *         0
 *     1       2
 *  3    4   5    6
 *
 *  上述坐标结构可以描述为
 *  节点n的左子节点： 2*n+1
 *  节点n的右子节点： 2*n+2
 *  节点n的父节点： （n-1）/2    #这个父节点的推论和向下取整也有关系。
 *  注意：上述坐标依旧要注意不能越界
 *
 *
 *  其他示例
 *         0
 *     1       2
 *  3    4   5    6
 *              13  14
 *
 *
 *  根据以上坐标特点就可以将数组视为二叉树进行遍历，实现随机存取，提高性能。当然也面临着大量空闲空间的风险
 */
public class OrderBinaryTree {

    class    OrderBinaryTreeCase{
        int [] arr;//二叉树扁平化处理

        public OrderBinaryTreeCase(int[] arr) {
            this.arr = arr;
        }

        /**
         *  @author:wenzhuo4657
        des:  前序遍历
         */
        public  void per(int index){
            System.out.println(arr[index]);
            if(index*2+1< arr.length){
                per(index);
            }
            if (index*2+2<arr.length){
                per(index*2+2);
            }
        }

    }



}
