package com.wells.单例模式.懒汉模式;

/**
 * Created by Wells on 2018年09月12日
 * 单例模式的懒汉实现五：线程安全
 */

public class SingletonLazyE {
    private static volatile SingletonLazyE singletonLazy;

    private SingletonLazyE() {

    }

    public static SingletonLazyE getInstance() {
        if (null == singletonLazy) {
            synchronized (SingletonLazyE.class) {
                if(null == singletonLazy){
                    singletonLazy = new SingletonLazyE();
                }
            }
        }
        return singletonLazy;
    }

    public static void main(String[] args) {
        /**
         * 线程安全的单例：(DCL:DoubleCheckedLocking)
         * 通过volatile与DCL机制实现了线程安全
         *
         * 缺点：代码复杂度高
         */
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(SingletonLazyE.getInstance().hashCode());
                }
            }).start();
        }
    }
}
