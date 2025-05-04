package cn.wenzhuo4657.com.Tree;
//二叉树
public class Bb {
    public static void main(String[] args) {
        int[]  arr={1,2,3,4,5,6,7};
        Binarytree i=new Binarytree(arr);
        i.zz();
        i.print();

    }
}


class node {
    //    左节点和右节点
    node left;
    node right;


    int a;

    public node(int a) {
        this.a = a;
    }

    public node() {
    }

    //    前序遍历:使用递归的方式，中序、后序、前序三种遍历只有代码顺序不同的区别
    public void print() {
        System.out.println(this.a);
        if (this.left != null) {
            this.left.print();
        }
        if (this.right != null) {
            this.right.print();
        }

    }


    //   前序查找：注意return的节点其值不会改变，保证了如果找到就一直向上传递，否则就返回一个null
    public node Finds(int a) {
        if (this.a == a) {
            return this;
        }
        node temp = null;
        if (this.left != null) {
            temp = this.left.Finds(a);
        }
        if (temp != null) {
            return temp;
        }//检验左子树是否找到目标，避免继续向下查找右子树
        if (this.right != null) {
            temp = this.right.Finds(a);
        }
        return temp;

    }

    /*
     * @Author wenzhuo4657
     * @Description
     * 删除节点
     * （1，如果该节点是叶子节点直接删除
     * （2，如果该节点是非叶子节点则删除该子树
     * @return
     * 1:未找到删除节点
     * -1：删除成功
     **/
    public int  delete(int a) {
        int i=1;

//        递归重复操作：判断当前节点的左节点和右节点是否需要删除
        if (this.left != null && this.left.a == a) {
            this.left = null;
            return -1;
        }
        if (this.right != null && this.right.a == a) {
            this.right = null;
            return -1;
        }


//        递归
        /*
        * 注意返回值和接受返回值的位置，
        * 在下面的递归中i的值将不受上面“i=1”的影响
        * */
        if (this.left != null) {
           i=this.left.delete(a);
        }
        if (i==-1){
            return i;
        }

        if (this.right != null) {
            i=this.right.delete(a);
        }

        return i;


    }

}


//二叉树
class Binarytree {
    private node root;
    private  int [] arr;

    public Binarytree(int a) {
        this.root = new node(a);
    }

    public Binarytree(node root) {
        this.root = root;

    }


    public Binarytree(int  []  arr) {
        this.arr=arr;

    }

    public void print() {
        if (this.root != null) {
            this.root.print();
        } else {
            System.out.println("无内容");
        }
    }


    public node Find(int a) {
        if (root != null) {
            return root.Finds(a);
        } else {
            System.out.println("无内容");
            return null;
        }
    }

    public void del(int a) {
        if (root != null) {
            if (root.a == a) {
                System.out.println("删除节点为根节点");
            } else {
                 if (root.delete(a)==-1){
                     System.out.println("删除成功");
                 }else {
                     System.out.println("未找到删除目标");
                 }

            }
        } else {
            System.out.println("无内容");
        }
    }

    public  void Invert(int index){
        if (arr==null&&arr.length==0){
            System.out.println("该数组无法转为二叉树");
            return ;
        }
//        root=new node(arr[index]);
        System.out.println(arr[index]);


        if ((index*2+1)< arr.length){
            this.Invert(index*2+1);

        }

        if ((index*2+2)< arr.length){
            this.Invert(index*2+2);
        }
    }

    public void zz(int i,node th){


        if (i< arr.length){
            th.a=arr[i];
            if (i*2+1<arr.length){
                th.left=new node();
                th.left.a=arr[i*2+1];

                zz(i*2+1,th.left);
            }

            if (i * 2 + 2 < arr.length) {
                th.right=new node();
                th.right.a=arr[i+2+2];

                zz(i*2+2,th.right);
            }

        }
    }

    public void zz(){
        if (arr.length>1){
            root=new node(arr[0]);
            zz(0,root);

        }
    }
}
