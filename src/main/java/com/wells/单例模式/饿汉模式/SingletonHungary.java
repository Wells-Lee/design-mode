package com.wells.单例模式.饿汉模式;

/**
 * Created by Wells on 2018年09月12日
 * 饿汉模式
 */

public class SingletonHungary {
    private static SingletonHungary singletonHungary = new SingletonHungary();

    // 将构造器设置为private禁止通过new进行实例化
    private SingletonHungary() {
    }

    public static SingletonHungary getInstance() {
        return singletonHungary;
    }
}
