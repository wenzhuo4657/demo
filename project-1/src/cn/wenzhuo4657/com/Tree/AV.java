package cn.wenzhuo4657.com.Tree;

public class AV {


    public static void main(String[] args) {
        n n=new n(1);
        n temp=n;
        for (int i=1;i<7;i++){
            temp.right=new n(i+1);
            temp=temp.right;
        }
        Avltree a=new Avltree(n);
        n.print();
        n.Revolve();
        System.out.println("=======");
        n.print();

    }

}

class n {
    int a;
    n left;
    n right;

    public n(int a) {
        this.a = a;
    }

    public n() {
    }

    public void print() {
        System.out.println(this.a);
        if (this.left != null) {
            this.left.print();
        }
        if (this.right != null) {
            this.right.print();
        }

    }

    /*
     * @Author wenzhuo4657
     * @Description
     * 向二叉排序树添加一个节点的底层方法
     * 关键值序列特点：
     * no.left.a<no.a
     * no.right.a>=no.a
     *
     *
     * 解释：
     * 该方法是遍历找到待添加节点的父亲节点，
     * @return
     **/
    public void add(n no) {

        if (this.a > no.a) {
            if (this.left == null) {
                this.left = no;
            } else {
//                向左递归
                this.left.add(no);
            }

        } else {
            if (this.right == null) {
                this.right = no;
            } else {
//                向右递归
                this.right.add(no);
            }
        }

    }

    private int leftheight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.height();
        }
    }

    private int rightheight() {

        if (this.right == null) {
            return 0;
        } else {
            return this.right.height();
        }
    }


    //返回传入节点的高度
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

//自适应旋转
    public void Revolve() {

        while (rightheight()-leftheight()>1){//右子树高度大于左子树高度：左循环
            if (left!=null&&left.rightheight()>left.leftheight()){
                //左子节点的右子树大于左子树高度：解决支链高度问题
                //必须保证左右子树主链长度最大
                left.LeftRevolve();

            }else {
                //主链长不一致
                LeftRevolve();
            }
        }

        while (leftheight()-rightheight()>1){//左子树高度大于右子树高度：右循环
            if (right!=null&&right.leftheight()>right.rightheight()){
                //右子节点的左右子树高度问题
                right.RightRevolve();
            }else {
                RightRevolve();
            }

        }




    }


    public void LeftRevolve() {
        n n = new n(this.a);
        if (this.left != null) {
            n.left = this.left;
        }
        if (this.right != null && this.right.left != null) {
            n.right = this.right.left;
        }
        this.a = this.right.a;
        if (this.right.right != null) {
            this.right = this.right.right;
        }
        this.left = n;
        if (rightheight() - leftheight() > 1) {
            LeftRevolve();
        }

    }

    public void RightRevolve() {
        n n = new n(this.a);
        n.right = this.right;
        n.left = this.left.right;
        this.a = this.left.a;
        this.left = this.left.left;
        this.right = n;
        if (leftheight() - rightheight() > 1) {
            RightRevolve();
        }
    }


}

class Avltree {
    n root;

    public Avltree(n root) {
        this.root = root;
    }

    int[] arr;

    public Avltree(n root, int arr[]) {
        this.root = root;
        this.arr = arr;
    }

    public void zz(int i, n th){


        if (i< arr.length){
            th.a=arr[i];
            if (i*2+1<arr.length){
                th.left=new n();
                th.left.a=arr[i*2+1];

                zz(i*2+1,th.left);
            }

            if (i * 2 + 2 < arr.length) {
                th.right=new n();
                th.right.a=arr[i+2+2];

                zz(i*2+2,th.right);
            }

        }
    }

    public void zz(){
        if (arr.length>1){
            root=new n(arr[0]);
            zz(0,root);

        }
    }


}
