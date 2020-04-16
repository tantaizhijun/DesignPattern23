package com.test.DesignPattern23.singleton;

/**
 * 饿汉式2 可用
 * 与饿汉式1类似，只不过将类实例化的过程放在了静态代码块中，
 * 也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。
 * 优缺点和饿汉式1是一样的。
 *
 */
public class Singleton4 {

    private static Singleton4 instance;

    static {
        instance = new Singleton4();
    }

    private Singleton4(){}

    public static Singleton4 getInstance() {
        return instance;
    }
}
