package com.wells.单例模式.懒汉模式;

/**
 * Created by Wells on 2018年09月12日
 * 单例模式的懒汉实现四：非线程安全
 */

public class SingletonLazyD {
    private static SingletonLazyD singletonLazy;

    private SingletonLazyD() {

    }

    public static SingletonLazyD getInstance() {
        if (null == singletonLazy) {
            synchronized (SingletonLazyD.class) {
                if(null == singletonLazy){
                    singletonLazy = new SingletonLazyD();
                }
            }
        }
        return singletonLazy;
    }

    public static void main(String[] args) {
        /**
         * 非线程安全的单例：(DCL:DoubleCheckedLocking)
         * 我们可以看到DCL(双重检查锁机制)很好的解决了懒加载单例模式的效率问题。这也是我们最常用到的方式；
         * 比SingletonLazyB效率高：因为我们只是在当前实例为null，也就是实例还未创建时才进行同步，否则就直接返回，这样就节省了很多无谓的线程等待时间
         *
         * 问：我们常用的这种方式是线程安全吗？
         * 答：否，原因是：JMM中的重排序导致非线程安全
         */
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(SingletonLazyD.getInstance().hashCode());
                }
            }).start();
        }
    }
}
