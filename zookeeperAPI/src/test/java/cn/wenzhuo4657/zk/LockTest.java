package cn.wenzhuo4657.zk;

/**
 * @className: Lock
 * @author: wenzhuo4657
 * @date: 2024/6/14 9:48
 * @Version: 1.0
 * @description:
 */
public class LockTest {
    public static void main(String[] args) {
        Ticket12306 ticket12306=new Ticket12306();

        Thread t1=new Thread(ticket12306,"携程");
        Thread t2 = new Thread(ticket12306,"飞猪");
        t1.start();
        t2.start();

    }

}