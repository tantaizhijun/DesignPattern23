package com.test.DesignPattern23.singleton;

/**
 * 懒汉式 2
 *  加了锁的懒汉式1  不推荐
 *  解决上面第三种实现方式的线程不安全问题，做个线程同步就可以了，于是就对getInstance()方法进行了线程同步。
 *
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 */
public class Singleton6 {

    private static Singleton6 singleton;

    private Singleton6() {}

    public static synchronized Singleton6 getInstance() {
        if (singleton == null) {
            singleton = new Singleton6();
        }
        return singleton;
    }
}
