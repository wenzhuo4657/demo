package cn.wenzhuo4657.com.si;

public class LinkedList {
    public static void main(String[] args) {
        CircularSinglelinkedlist boys1=new CircularSinglelinkedlist();
        boys1.add(4);
        boys1.print();
    }
}

class BidirectionalNodes {
    int in;
    String name;
    String nameS;

    BidirectionalNodes next;
    BidirectionalNodes pro;

    public BidirectionalNodes(int in, String name, String nameS) {
        this.in = in;
        this.name = name;
        this.nameS = nameS;
    }

    @Override
    public String toString() {
        return "BidirectionalNodes{" +
                "in=" + in +
                ", name='" + name + '\'' +
                ", nameS='" + nameS + '\'' +
                '}';
    }
}


class Node {
    int in;
    String name;
    String nameS;

    Node next;

    public Node(int in, String name, String nameS) {
        this.in = in;
        this.name = name;
        this.nameS = nameS;
    }

    @Override
    public String toString() {
        return "Node{" +
                "in=" + in +
                ", name='" + name + '\'' +
                ", nameS='" + nameS + '\'' +
                '}';
    }
}


class Singlelinkedlist {
    Node head = new Node(0, "", "");
    //注意：作为链表的头部尽量不要存储实际数据


    //    给链表添加一个节点
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }

    }


//    按节点的no属性的值有序添加

    public void add_S(Node node) {
        Node temp = head;
        boolean flag = true;//用于判断是否找到插入位置
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.in > node.in) {

                break;
            }
            if (temp.next.in == node.in) {
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.println("该节点应插入位置已被占有");
        }
    }

    //    修改链表上的某个节点
    public void Revise(Node node) {
        Node temp = head;
        //1.遍历链表：找到要修改的节点位置
        boolean flag = false;
        while (true) {
//            遍历到尾部时退出
            if (temp.next == null) {
                System.out.println("找到");
                break;
            }
            if (temp.next.in == node.in) {

                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {

            node.next = temp.next.next;
            temp.next = node;
        } else {
            System.out.println("没有找到该节点");
        }
    }

    //    根据编号删除指定节点
    public void Delete(int in) {
        Node temp = head;
        //1.找到指定节点的位置
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.in == in) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

//        判断是否删除
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该编号所指向的节点");
        }

    }

    //    返回链表的有效数据的个数（不包括头结点）
    public int data_number() {
        Node temp = getHead().next;
        int number = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            number++;
            temp = temp.next;

        }
        return number;

    }

    //  得到倒数第k个节点
    public Node getnode(int i) {
        Node temp = getHead();
        //1.得到链表的总长度
        int size = data_number();
        //2.校验是否可以得到该序号
        if (i < 0 || (size - i) < 0) {
            throw new RuntimeException("倒数第k个节点校验不合格");
        }
        //2.遍历得到倒数第i（size-i）个节点，
        for (int a = 0; a <= size - i; a++) {
            temp = temp.next;
        }
        return temp;
    }

    //    单链表的反转
    public void Rollback() {
        //1.判断是否可以反转，即链表长度大于1
        if (head.next == null || head.next.next == null) {
            return;
        }
        //2.反转  :通过操作得到一个临时的反转链表
        Node crp = head.next;//表示要操作的节点
        Node temp = null;//表示临时，用于暂存当前操作节点的下一个节点
        Node temp_list = new Node(0, "", "");//表示临时链表
        while (crp != null) {
            temp = crp.next;
            crp.next = temp_list.next;
            temp_list.next = crp;//将crp插入链表的第一个有效位置，也就是头部
            crp = temp;//将节点指向原链表的下一个节点，重复进行此操作
        }
//     3.得到反转链表
        head.next = temp_list.next;

    }


    //    打印链表
    public void print() {
        while (true) {
            if (head.next == null) {
                System.out.println("链表为空，无需打印");
                break;
            }
            Node temp = head.next;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;

            }
            break;
        }

    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}


class Doublylinkedlist {
    private BidirectionalNodes head = new BidirectionalNodes(0, "", "");

    public void add(BidirectionalNodes node) {

        //注意：作为链表的头部尽量不要存储实际数据
        BidirectionalNodes temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                node.pro = temp;
                break;
            }


            temp = temp.next;
        }

    }

    //    根据编号删除指定节点
    public void Delete(int in) {
        BidirectionalNodes temp = head;
        //1.找到指定节点的位置
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.in == in) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

//        判断是否删除
        if (flag) {
            temp.next.pro = temp.pro;
            temp.pro.next = temp.next;
        } else {
            System.out.println("没有找到该编号所指向的节点");
        }

    }

    //    打印链表
    public void print() {
        while (true) {
            if (head.next == null) {
                System.out.println("链表为空，无需打印");
                break;
            }
            BidirectionalNodes temp = head.next;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;

            }
            break;
        }

    }


}

class BoyNodes {
    int no;
    BoyNodes next;

    public BoyNodes(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNodes getNext() {
        return next;
    }

    public void setNext(BoyNodes next) {
        this.next = next;
    }
}


class CircularSinglelinkedlist {
    private BoyNodes first;
    private  BoyNodes curr;

    public BoyNodes getFirst() {
        return first;
    }

    public void setFirst(BoyNodes first) {
        this.first = first;
    }

    public BoyNodes getCurr() {
        return curr;
    }

    public void setCurr(BoyNodes curr) {
        this.curr = curr;
    }

    public void add(int n) {
        if (n < 1) {
            throw new RuntimeException("环形队列链表创建失败：输入参数过小");
        }

        BoyNodes curr = null;//指向最后链表一个节点，且该节点需要与第一个节点想点
        for (int i = 1; i <= n; i++) {
            BoyNodes boy = new BoyNodes(i);
            if (i == 1) {

                first = boy;
                first.setNext(first);
                curr = first;
                /*
                 * 先将第一个节点成环，并使curr节点指向链表最后一个节点
                 * */
            } else {
//                将后续节点插入该环，并保证curr始终指向队列的最后一个节点
                    curr.setNext(boy);
                    boy.setNext(first);
                    curr=boy;

            }
        }
        this.curr=curr;
    }

//    遍历节点的编号
    public  void print(){
        if (first==null){
            throw  new RuntimeException("遍历环形队列失败：没有初始化");
        }
        BoyNodes temp=first;
        while ( true){
            if (temp.next!=first){
                System.out.printf("小孩的编号%d\n",temp.no );
                temp=temp.next;
            }else {
                System.out.printf("小孩的编号%d\n",temp.no );
                break;
            }
        }
    }
}




