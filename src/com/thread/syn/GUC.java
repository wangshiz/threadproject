package com.thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by @author wangsz on 2020/9/26 17:17
 */
//测试JUC安全类型的集合
public class GUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            });
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
