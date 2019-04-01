package com.DesignPattern23.proxy.jdkProxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理人: 媒婆
 */
public class JdkMeipo implements InvocationHandler {

    private Person target;

    /**
     * 获取被代理人信息,,返回代理人对象
     * @return
     */
    public Object getInstance(Person target) {
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**
     * 动态执行被代理人的方法,,并进行增强
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置增强
        dosomethingBefore();
        System.out.println("你的性别是" + this.target.getSex() + ",帮你找对象");

        //执行被代理人方法
        method.invoke(this.target,args);

        //后置增强
        dosomethingAfter();
        System.out.println("滿意吗?????????");
        return null;
    }

    //前置增强
    private void dosomethingBefore() {
        //前置增强
        System.out.println("方法执行前执行");
    }

    //后置增强
    private void dosomethingAfter() {
        System.out.println("方法执行后执行");
    }
}
