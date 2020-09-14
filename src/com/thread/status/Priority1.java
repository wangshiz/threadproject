package com.thread.status;

/**
 * Created by @author wangsz on 2020/9/14 21:51
 * 线程的优先级
 * 不是高优先级的线程就一定先比低优先级执行完，而是高优先级线程先执行的概率比低优先级的线程高。
 */
public class Priority1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()
                + "-->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(2);
        t3.start();

        t4.setPriority(3);
        t4.start();

        t5.setPriority(4);
        t5.start();

        t6.setPriority(6);
        t6.start();


    }

}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
         + "-->" + Thread.currentThread().getPriority());
    }
}
