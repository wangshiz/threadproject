package com.thread.demo;

/**
 * lambda表达式只能有一行代码的情况下才能简化成一行
 * 如果有多行就用代码块包裹
 *
 * 前提是接口为函数式接口
 *
 * 多个参数也可以去掉参数类型 要去掉就都去掉
 */
public class Lambda2 {
    public static void main(String[] args) {
        ILove love = (a, b) -> System.out.println("i love you --->" + a + "," + b);
        love.love(520, 502);

        love = (a, b) -> System.out.println("i love you --->" + a);
        love.love(521, 502);
    }
}

interface ILove {
    void love(int a, int b);
}

//class Love implements ILove {
//    @Override
//    public void love(int a, int b) {
//        System.out.println("i love you --->" + a + "," + b);
//    }
//}
