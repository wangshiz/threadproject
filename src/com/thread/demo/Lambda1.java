package com.thread.demo;

public class Lambda1 {

    //静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //匿名内部类 没有类名称 比锡借助接口或者父类
        like = new Like() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();


        //用lambda简化
        like = () -> System.out.println("I like lambda5");
        like.lambda();
    }
}

//定义一个函数式接口
interface ILike {
    void lambda();
}

//实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
