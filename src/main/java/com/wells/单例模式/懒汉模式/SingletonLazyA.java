package com.wells.单例模式.懒汉模式;

/**
 * Created by Wells on 2018年09月12日
 * 单例模式的懒汉实现一：线程不安全
 */

public class SingletonLazyA {
    private static SingletonLazyA singletonLazy;

    private SingletonLazyA() {

    }

    public static SingletonLazyA getInstance() {
        if (null == singletonLazy) {
            try {
                // 模拟在创建对象之前做一些准备工作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singletonLazy = new SingletonLazyA();
        }
        return singletonLazy;
    }

    public static void main(String[] args) {
        /**
         * 非线程安全的单例
         */
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(SingletonLazyA.getInstance().hashCode());
                }
            }).start();
        }
    }
}
