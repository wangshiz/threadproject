package com.thread.syn;

/**
 * Created by @author wangsz on 2020/9/14 22:30
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "tom").start();
        new Thread(station, "jerry").start();
        new Thread(station, "黄牛").start();
    }

}

class BuyTicket implements Runnable {

    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    //synchronized 同步方法 锁的是this
    private synchronized void buy() {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNum--);
    }
}