package com.DesignPattern23.singleton;

/**
 * 懒汉式3
 * 线程安全  同步代码块 不推荐用
 *  由于第四种实现方式同步效率太低，所以摒弃同步方法，改为同步产生实例化的的代码块。
 *  但这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一致，
 *  假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
 *  另一个线程也通过了这个判断语句，这时便会产生多个实例。
 */

public class Singleton7 {

    private static Singleton7 singleton;

    private Singleton7() {}

    public static Singleton7 getInstance() {
        //此处如果两个线程都通过了检查，就会创建多个实例，最好在锁里面再检查一次是否为null
        if (singleton == null) {
            //加锁
            synchronized (Singleton7.class) {
                singleton = new Singleton7();
            }
        }
        return singleton;
    }
}
