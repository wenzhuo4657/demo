package cn.wenzhuo4657;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                // do something
            }
        };
        thread.start();
    }
}