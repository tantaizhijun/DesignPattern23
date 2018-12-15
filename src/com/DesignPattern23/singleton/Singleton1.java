package com.DesignPattern23.singleton;

/**
 * 懒汉式(静态内部类) ---最经典的单例写法
 *  这种写法,既解决了安全问题,又解决了性能问题
 *
 */
public class Singleton1 {
    /**
     * 1.先声明一个静态内部类
     * private 私有保证不允许别人修改
     * static 保证全局唯一
     */
    private static class LazyHolder {
        //final 防止内部误操作
        //如:cglib的代理模式是产生子类,,就有可能进行修改重新赋值,
        private static final Singleton1 INSTANCE = new Singleton1();
    }
    //2.私有化构造方法
    private Singleton1() {}
    //注: 如果自己不写构造,并私有化,其实默认有一个public的无惨构造,就会随时可以实例化

    //3.提供静态方法获取实例
    //final 确保别人不能修改
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
