package cn.wenzhuo4657.com.Tree;
//线索二叉树树的建立和使用
public class BinaryTree_plus {
    public static void main(String[] args) {
        Nodes i1=new Nodes(8);
        Nodes i2=new Nodes(3);
        Nodes i3=new Nodes(10);
        Nodes i4=new Nodes(1);
        Nodes i5=new Nodes(6);
        i4.left=i2;
        i2.left=i1;
        i2.right=i3;
        i4.right=i5;
        ClueBinaryTree ii=new ClueBinaryTree(i4);
        ii.Clue(i4);
        ii.print();

    }
}

class  Nodes{
      int i;
      Nodes left;
      Nodes right;
//      线索化指针的类型
//    0：左子树、右子树或者无
//    1：前驱节点、后继节点
      int TypeLeft;
      int Typeright;

    public Nodes(int i) {
        this.i = i;
    }
}


class  ClueBinaryTree{
    Nodes root;
//    保留二叉树时上一个节点的引用，用于线索化二叉树
    Nodes pre;

    public ClueBinaryTree(Nodes root) {
        this.root = root;
    }

    /*
     * @Author wenzhuo4657
     * @Description
     * pre：指向上一个节点，绑定后继节点
     * node:指向当前节点，绑定前驱节点
     * 错开进行绑定，保证node节点遍历完成时线索化同样完成
     * 线索化性质：中序遍历
     * @return
     **/
    public  void Clue(Nodes node){
//        递归结束条件
        if (node==null){
            return;
        }
//        递归线索化左子树
        Clue(node.left);

//        线索化当前节点
        if (node.left==null){
            node.left=pre;
            node.TypeLeft=1;
        }
        if (pre!=null&&pre.right==null){
            pre.right=node;
            pre.Typeright=1;
        }

//        保证线索化时pre指向上一个节点
        pre=node;

//        递归线索化右子树
        Clue(node.right);

    }


    /*
     * @Author wenzhuo4657
     * @Description
     * 功能：遍历中序线索二叉树
     * 根据中序遍历的特点所持有的特殊遍历算法，其遍历结果仍与为线索化前的二叉树的遍历结果相同
     * @return
     **/
    public void print(){
//        表示当前遍历的节点
        Nodes node=this.root;
        while (node!=null){
            while (node.TypeLeft==0){
                node=node.left;
            }
//            打印
            System.out.println(node.i);
            while (node.Typeright==1){
                node=node.right;
                System.out.println(node.i);
            }
            node=node.right;


        }
    }
}
