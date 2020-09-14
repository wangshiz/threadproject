package com.thread.demo;

/**
 * Created by @author wangsz on 2020/9/3 22:11
 *
 * 继承Thread类
 * 子类继承Thread类具备多线程的能力
 * 启动线程：子类对象.start()
 * 不建议使用：避免OOP单继承局限性
 */
public class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("i am looking code ---" + i);
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();

        //thread1.start();
        thread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("i am learning thread ---" + i);
        }
    }
}
