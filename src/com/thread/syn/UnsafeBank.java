package com.thread.syn;

/**
 * Created by @author wangsz on 2020/9/14 22:39
 */
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(1000, "结婚基金");
        Drawing you = new Drawing(account, 50, "you");
        Drawing girlfriend = new Drawing(account, 100, "girlfriend");

        you.start();
        girlfriend.start();
    }

}


class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //synchronized 默认锁的是this
    @Override
    public void run() {
        //锁的是变化的量
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够了 取不了");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为: " + account.money);
            System.out.println(this.getName() + "手里的钱：" + nowMoney);

        }

    }
}