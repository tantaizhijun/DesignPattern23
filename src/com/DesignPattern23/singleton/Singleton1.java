package com.DesignPattern23.singleton;

/**
 * 静态内部类 推荐用
 *
 *  既解决了安全问题,又解决了性能问题
 *
 *  这种方式跟 饿汉式 方式采用的机制类似，但又有不同。
 *  两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 *  不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
 *  而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，
 *  调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 *
 *  类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 *
 * 优点：避免了线程不安全，延迟加载，效率高。
 *
 * 但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的。这种情况不多做说明了，使用时请注意。
 */
public class Singleton1 {
    /**
     * 1.先声明一个静态内部类
     * private 私有保证不允许别人修改
     * static 保证全局唯一
     */
    private static class LazyHolder {
        //final 防止修改
        //如:cglib的代理模式是产生子类,,就有可能进行修改重新赋值,
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    private Singleton1() {}
    //注: 如果自己不写构造,并私有化,其实默认有一个public的无惨构造,就会随时可以实例化

    //3.提供静态方法获取实例 final禁止修改
    public static final Singleton1 getInstance() {
        return LazyHolder.INSTANCE;
    }

    /** 注:
     * 我们所有的代码, 在java的反射机制下都是裸奔的
     * 反射机制可以拿到private修饰的内容
     * 可以理解为即使加上private也不一定靠谱
     */

    //类装载到JVM的过程
    //1.从上到下(必须先声明后使用)
    //2.先属性,后方法
    //3.先静态,后动态

    static{
        //
    }
    /**
     * 知识点:
     *   不管类是否实例化,静态代码块总会在classLoader执行完就加载完毕
     *   而且,静态块中的内容,只能访问静态属性或静态方法
     *   静态的属性或方法,可以用 类名点 进行调用
     *   jvm内存中的静态区,,是公共的
     */
}
