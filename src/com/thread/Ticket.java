package com.thread;

public class Ticket implements Runnable {


    private int ticketNum = 100;

    @Override
    public void run() {
        while (ticketNum > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----->拿到了第" + ticketNum-- + "张票");
        }
    }


    public static void main(String[] args) {
        Ticket t = new Ticket();

        new Thread(t, "小明").start();
        new Thread(t, "老师").start();
        new Thread(t, "黄牛党").start();


    }
}
