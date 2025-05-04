package org.example;

import java.util.concurrent.*;

public class Main {
    public static class MyRunnable implements Runnable {
        int a;
        @Override
        public void run() {
            synchronized (this){
                System.out.println(a++);
            }
        }
    }
    public static class MyCallable implements Callable<String> {
        int a;
        @Override
        public String call() throws Exception {
            char x= (char) a++;
            Thread.sleep(1000);
            return String.valueOf(x);
        }
    }
    static  int cnt=100;
    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        Runnable接口
//        MyRunnable myRunnable = new MyRunnable();
//
//        for (int i=0;i<cnt;i++){
//            Thread thread = new Thread(myRunnable);
//            thread.start();
//        }

//        Callable<String>
//        MyCallable myCallable=new MyCallable();
//        for (int i=0;i<cnt;i++){
//            FutureTask<String> ft;
//            ft = new FutureTask<>(myCallable);
//            Thread thread = new Thread(ft);
//            thread.start();
//            String s = ft.get();//阻塞方法
//            System.out.println(s);
//        }

//        Executors：线程池

        ThreadFactory daemonThreadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true); // 设置为守护线程
            return thread;
        };
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newCachedThreadPool(daemonThreadFactory);//设置创建线程方式
        for (int i=0;i<cnt;i++){
            executorService.execute(myRunnable);
            executorService.shutdown();//拒绝新任务。

        }
        System.out.println(myRunnable);



    }
    Object object = new Object();
    public void method1() {
        synchronized (object) {

        }
    }
}