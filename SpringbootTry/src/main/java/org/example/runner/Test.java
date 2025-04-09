package org.example.runner;

public class Test {
    public static void main(String[] args) {
        //测试系统监控器
        testSystemMonitor();
    }
 
    /**
     * 测试系统监控器
     */
    public static void testSystemMonitor() {
        SystemMonitor sm = new SystemMonitor();
        sm.start();
        try {
            //运行 10 秒后停止监控
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("监控任务启动 10 秒后，停止...");
        sm.stop();
    }
}
/*系统监控器*/
class SystemMonitor {
 
    private Thread t;
    //线程中断标识
    private volatile boolean stop = false;
 
    /**
     * 启动一个线程监控系统
     */
    void start() {
        t = new Thread(() -> {
            while (!stop) {//判断当前线程是否被打断
                System.out.println("正在监控系统...");
                try {
                    Thread.sleep(3 * 1000L);//执行 3 秒
                    System.out.println("任务执行 3 秒");
                    System.out.println("监控的系统正常!");
                } catch (InterruptedException e) {
                    System.out.println("任务执行被中断...");
                    //重新设置线程为中断状态，保证JVM抛异常情况下，中断状态仍为true。
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
    }
    //线程中断
    void stop() {
        stop = true;
        t.interrupt();
    }
}