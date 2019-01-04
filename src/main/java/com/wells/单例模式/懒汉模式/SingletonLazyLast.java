package com.wells.单例模式.懒汉模式;

/**
 * Created by Wells on 2018年09月12日
 * 单例模式的懒汉实现最终版：线程安全
 * 基于类初始化实现了线程安全的单例
 */

public class SingletonLazyLast {
    private SingletonLazyLast() {
    }

    public static SingletonLazyLast getInstance() {
        return SingletonInstance.instance;
    }

    private static class SingletonInstance {
        static SingletonLazyLast instance = new SingletonLazyLast();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(SingletonLazyLast.getInstance().hashCode());
                }
            }).start();
        }
    }
}
