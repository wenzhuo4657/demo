package cn.wenzhuo4657.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * @className: Ticket12306
 * @author: wenzhuo4657
 * @date: 2024/6/14 9:58
 * @Version: 1.0
 * @description:
 */
public class Ticket12306 implements  Runnable{
    private  int tickets=10;
    private InterProcessMutex lock ;

    public Ticket12306() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(2, 6);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("47.92.150.10:2181")
                .sessionTimeoutMs(3 * 1000)
                .connectionTimeoutMs(6 * 1000)
                .retryPolicy(retryPolicy).build();
        client.start();
        lock=new InterProcessMutex(client,"/lock");

    }

    @Override
    public void run() {

        while (true){
            try {
//                1,获取锁,这里是阻塞获取的
                lock.acquire(3, TimeUnit.SECONDS);
                if (tickets>0){
                    System.out.println("剩余票数为"+--tickets);
                    System.out.println(Thread.currentThread());
                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    lock.release();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}