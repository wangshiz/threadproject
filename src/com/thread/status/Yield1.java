package com.thread.status;

/**
 * Created by @author wangsz on 2020/9/13 19:48
 * 礼让线程
 * 礼让不一定成功 看cpu心情
 */
public class Yield1 {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}


class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}