package cn.wenzhuo4657.com.si;

public class HashTable {
    public static void main(String[] args) {

    }
}

class  node{
    int id;
    String Name;
    String   Resume;
    int Wages;


    node next;

}


class  node_list{
    node next;

    public  void add(node node){
        if (next==null){
            next=node;
            return;
        }
//        临时指针
        node temp=next;
        while (true){
            if (temp==null){
                temp=node;
                break;
            }
            temp=temp.next;
        }
        return;
    }


    public  void print(){
        if (next==null){
            return;
        }
        for (node temp=next;temp!=null;temp=temp.next){
            System.out.println(temp.toString());
        }
    }
}

//哈希表：数组+链表，
class hastab{
    node_list [] tab;

    public hastab(int  size) {
        tab=new node_list[size];
        //      注意：  java程序局部变量不会进行初始化
        for (int i=0;i<size;i++){
            tab[i]=new node_list();
        }
    }
}
