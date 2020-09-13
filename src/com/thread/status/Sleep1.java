package com.thread.status;

import com.thread.Ticket;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by @author wangsz on 2020/9/13 19:28
 * 作用 模拟网络延时
 *
 *
 * sleep(时间)指定当前线程阻塞的毫秒数
 * sleep存在异常InterruptedException
 * sleep时间达到后线程进入就绪状态
 * sleep可以模拟网络延时，倒计时等
 * 每个对象都有一个锁 sleep不会释放锁
 */
public class Sleep1 {

    public void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Date startDate = new Date(System.currentTimeMillis());

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startDate));
                startDate = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
