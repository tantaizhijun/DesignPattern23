package com.DesignPattern23.proxy.jdkProxy;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        //一般的方法调用
//        new Amay().findLove();

        //使用代理的方式
        //根据被代理人, 获取代理人  并执行方法
        //查看此处的o对象的引用,可以发现已经是代理对象了,他属于proxy类对象
        Person o = (Person) new Meipo().getInstance(new Amay());
        o.findLove();

        /**原理:
         *  拿到被代理人对象引用,然后获取他的接口
         *   jdk代理重新生成一个类, 同时实现我们给的代理人对象所实现的接口
         *   重新生成一个class字节码
         *   然后编译
         */

    }
}
