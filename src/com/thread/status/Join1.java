package com.thread.status;

/**
 * Created by @author wangsz on 2020/9/13 19:52
 */
public class Join1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Join1 join1 = new Join1();
        Thread thread = new Thread(join1);
        thread.start();

        for (int i = 0; i < 200; i++) {
            if (i == 100) {
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
