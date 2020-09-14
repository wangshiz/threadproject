package com.thread.status;

/**
 * Created by @author wangsz on 2020/9/14 22:06
 *
 * 线程分用户线程和守护线程
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 * 如 后台记录操作日志 监控内存 垃圾回收
 */
public class Daemon1 {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);   //默认是false 表示用户线程 正常的线程都是用户线程
        thread.start();
        new Thread(you).start();

    }
}

class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}


class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("========goodbye world========");
    }
}
