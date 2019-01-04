package com.wells.单例模式.懒汉模式;

/**
 * Created by Wells on 2018年09月12日
 * 单例模式的懒汉实现三：非线程安全
 */

public class SingletonLazyC {
    private static SingletonLazyC singletonLazy;

    private SingletonLazyC() {

    }

    public static SingletonLazyC getInstance() {
        if (null == singletonLazy) {    // 代码1
            synchronized (SingletonLazyC.class) {
                singletonLazy = new SingletonLazyC();
            }
        }
        return singletonLazy;
    }

    public static void main(String[] args) {
        /**
         * 对创建对象的代码加锁，从结果看来，这种方式不能保证线程安全，为什么呢？
         * 我们假设有两个线程A和B同时走到了‘代码1’，因为此时对象还是空的，所以都能进到方法里面，线程A首先抢到锁，创建了对象。
         * 释放锁后线程B拿到了锁也会走到‘代码2’，也创建了一个对象，因此多线程环境下就不能保证单例了
         */
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(SingletonLazyC.getInstance().hashCode());
                }
            }).start();
        }
    }
}
