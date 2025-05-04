package cn.wenzhuo4657.com.Tree;

public class BinarySortTree {
    public static void main(String[] args) {
        int [] a={7,3,10,5,1,9,2};
        SortTree m=new SortTree();
        for (int i:a){
            m.add(new no(i));
        }
       m.root.print();
        System.out.println("==========");
        m.del1(3);
        m.print();




    }
}




class SortTree{
    no root;

    public SortTree(no root) {
        this.root = root;
    }

    public SortTree() {
    }

    public void add(no no){
        if (root==null){
            root=no;
        }else{
            root.add(no);
        }

    }
    public void print(){
        if (root!=null){
            root.print();
        }else {
            System.out.println("该树为空");
        }

    }
    public no  search1(int value){
        if (root!=null){
            return root.search1(value);
        }else {
            System.out.println("当前树为空");
            return null;
        }

    }

    public no search2(int value){
        if (root!=null){
            return root.search2(value);
        }else {
            System.out.println("当前树为空");
            return null;
        }
    }

    /*
     * @Author wenzhuo4657
     * @Description
     * @return
     * 传入树的最小值
     **/
    public no  seatch3(no no){
        if (no.left!=null){
            seatch3(no.left);
        }else {
            del1(no.a);
        }
        return no;
    }


/*
 * @Author wenzhuo4657
 * @Description
 * 删除节点
 * @return
 **/
    public void del1(int value){
        if (root==null){
            System.out.println("当前树为空");
            return;
        }
        no target=search1(value);
        if (target==null){
            System.out.println("没有找到要删除的节点");
            return;
        }

        no targetPatents=search2(value);
        //开始删除
        if (target==root){//当这个if没有生效时，目标节点和目标节点的父节点均不为空，无需在进行判断
            System.out.println("删除节点为根节点，已删除");
            root=null;

        }else if (target.left==null&&target.right==null){//删除叶子节点
            if (targetPatents.left!=null&&targetPatents.left==target){
                targetPatents.left=null;
            }else {
                targetPatents.right=null;
            }
        }else if (target.left!=null&&target.right!=null){//删除具有两棵子树的节点

            /*
            寻找到左子树的最大值节点或是右子树的最小节点，替换到当前节点的位置

            * */
            no  temp=seatch3(target.right);
       //替换其值:此处因为节点内只有关键序列值，所以只用替换这个
       target.a=temp.a;






        }else {//删除具有一棵子树的节点
            if (target==targetPatents.left){
                if (target.left!=null){
                    targetPatents.left=target.left;
                }else {
                    targetPatents.left=target.right;
                }
            }else {
                if (target.left!=null){
                    targetPatents.right=target.left;
                }else {
                    targetPatents.right=target.right;
                }
            }


        }
        System.out.println("删除成功");


    }

}



//节点
class  no implements Comparable<nod>{
    int a;
    no left;
    no right;

    public no(int a) {
        this.a = a;
    }

    @Override
    public int compareTo(nod o) {
        return this.a-o.a;
    }

/*
 * @Author wenzhuo4657
 * @Description
 * 向二叉排序树添加一个节点的底层方法
 * 关键值序列特点：
 * this.left.a<this.a
 * this.right.a>=this.a
 *
 *
 * 解释：
 * 该方法是遍历找到待添加节点的父亲节点，
 * @return
 **/
    public  void add(no no){

        if (this.a>no.a){
            if (this.left==null){
                this.left=no;
            }else {
//                向左递归
               this.left.add(no);
            }

        }else {
            if (this.right==null){
                this .right=no;
            }else {
//                向右递归
                this.right.add(no);
            }
        }

    }





//中序遍历
    public void print() {

        if (this.left != null) {
            this.left.print();
        }
        System.out.println(this.a);
        if (this.right != null) {
            this.right.print();
        }

    }


    /*
     * @Author wenzhuo4657
     * @Description
     * 查找目标节点并返回
     *
     * 注意：由于二叉排序树的特点，并不需要类似遍历的查找，只需要对任意节点的左子树或右子树进行下沉
     *
     * @return
     * no 目标节点
     * null  没找到
     **/

    public  no search1(int a){

        if (this.a==a){
            return this;
        } else if (a<this.a) {
            if(this.left!=null){
                return this.left.search1(a);
            }else {
                return null;

            }


        }else {
            if (this.right != null) {
                return this.right.search1(a);
            } else {
                return null;

            }
        }

    }


/*
 * @Author wenzhuo4657
 * @Description
 * 查找目标节点的父节点
 *
 * @return
 **/
    public no search2(int a){
        if (this==null){
            return null;
        }
        if (this.left!=null&&this.left.a==a){
            return  this;
        }else if (this.right!=null&&this.right.a==a){
            return this;
        }

        if (a<this.a) {
            if (this.left!=null){
               return this.left.search2(a);
            }else{
                return null;
            }//此结构符合二叉排序树的特点，提高了查找效率
            // ，重点在于：当左子树或右子树没有找到时会向上递归null避免另一边树的递归调用

        }else {
            if (this.right!=null){
                return this.right.search2(a);
            }else {
                return null;
            }
        }
    }
}
