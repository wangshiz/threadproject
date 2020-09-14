package com.thread.demo;

import java.util.concurrent.*;


/**
 * 实现callable接口，需要返回值类型
 * 重写call方法，需要抛出异常
 * 创建目标对象 Callable1 call1 = new Callable1();
 * 创建执行服务 ExecutorService service = Executors.newFixedThreadPool(2);
 * 提交执行 Future<Boolean> r1 = service.submit(call1);
 * 获取结果 boolean rs1 = r1.get();
 * 关闭服务 service.shutdown();
 *
 * 可以定义返回值
 * 可以抛出异常
 *
 */
public class Callable1 implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 20; i++) {
            System.out.println("i am looking code ---" + i);
        }

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable1 call1 = new Callable1();
        Callable1 call2 = new Callable1();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Boolean> r1 = service.submit(call1);
        Future<Boolean> r2 = service.submit(call2);

        boolean rs1 = r1.get();
        boolean rs2 = r2.get();

        System.out.println(rs1);
        System.out.println(rs2);

        service.shutdown();
    }
}
