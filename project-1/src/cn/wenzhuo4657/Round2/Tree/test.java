package cn.wenzhuo4657.Round2.Tree;

/**
 * @author: wenzhuo4657
 * @date: 2025/3/14
 * @description: 二叉树遍历测试
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树--->根结点---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树---> 根结点
 *
 */
public class test {




    /**
     *  @author:wenzhuo4657
        des:  二叉树简单定义
    */
    class  HeroNode{
        private  int no;
        private String name;
        private HeroNode leftNode;
        private HeroNode rightNode;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(HeroNode leftNode) {
            this.leftNode = leftNode;
        }

        public HeroNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(HeroNode rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        /**
         *  @author:wenzhuo4657
            des:  前序遍历
        */
        public  void per(HeroNode node){
            System.out.println(node.toString());
            if(node.leftNode!=null){
                per(node.leftNode);
            }
            if (node.rightNode!=null){
                per(node.rightNode);
            }
        }


        /**
         *  @author:wenzhuo4657
            des:  中序遍历
         */

        public  void mid(HeroNode node){

            if(node.leftNode!=null){
                mid(node.leftNode);
            }
            System.out.println(node.toString());
            if (node.rightNode!=null){
                mid(node.rightNode);
            }
        }


        /**
         *  @author:wenzhuo4657
            des: 后序遍历
        */
        public  void after(HeroNode node){

            if(node.leftNode!=null){
                after(node.leftNode);
            }

            if (node.rightNode!=null){
                after(node.rightNode);
            }
            System.out.println(node.toString());
        }

    }






}
