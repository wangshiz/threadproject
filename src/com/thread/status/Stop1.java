package com.thread.status;

/**
 * Created by @author wangsz on 2020/9/13 19:16
 *
 * 测试stop
 * 1.建议线程正常停止 利用次数 不建议死循环
 * 2.建议使用标志位  设置一个标志位
 * 不要使用stop 或者 destroy 等过时或者jdk不建议使用的方法
 *
 */
public class Stop1 implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run thread" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        Stop1 stop1 = new Stop1();
        new Thread(stop1).start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("main" + i);
            if (i == 9000) {
                stop1.stop();
                System.out.println("this thread stop");
            }


        }
    }
}
