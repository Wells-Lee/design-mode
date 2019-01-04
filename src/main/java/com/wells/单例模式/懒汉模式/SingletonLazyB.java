package com.wells.单例模式.懒汉模式;

/**
 * Created by Wells on 2018年09月12日
 * 单例模式的懒汉实现二：线程安全，但性能太低
 */

public class SingletonLazyB {
    private static SingletonLazyB singletonLazy;

    private SingletonLazyB() {

    }

    public static synchronized SingletonLazyB getInstance() {
        if (null == singletonLazy) {
            try {
                // 模拟在创建对象之前做一些准备工作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singletonLazy = new SingletonLazyB();
        }
        return singletonLazy;
    }

    public static void main(String[] args) {
        /**
         * 线程安全的单例：
         * 对getInstance方法进行加锁
         * 这种方式达到了线程安全，但是缺点就是效率太低，是同步运行的，下个线程想要取得对象，就必须要等上一个线程释放，才可以继续执行
         */
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(SingletonLazyB.getInstance().hashCode());
                }
            }).start();
        }
    }
}
