package com.thread.demo;

/**
 * Created by @author wangsz on 2020/9/3 22:22
 *
 * 实现Runnable接口
 * 实现接口Runnable具有多线程能力
 * 启动线程：传入目标对象+Thread对象.start()
 * 推荐使用：避免单继承局限性，灵活方便，方便同一个对象被多个线程使用
 */
public class Runnable1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("i am looking code ---" + i);
        }
    }

    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();

        new Thread(runnable1).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("i am learning thread ---" + i);
        }
    }
}
