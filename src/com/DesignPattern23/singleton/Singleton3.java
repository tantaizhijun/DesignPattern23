package com.DesignPattern23.singleton;

/**
 * 饿汉式2 可用
 *  优点：写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费
 */
public class Singleton3 {

    //静态常量 + final 不允许修改
    private final static Singleton3 instance = new Singleton3();

    //私有化构造，禁止创建实例
    private Singleton3(){}

    public static Singleton3 getInstance(){
        return instance;
    }

}
