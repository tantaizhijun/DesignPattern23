package com.DesignPattern23.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理人: 媒婆
 */
public class Meipo implements InvocationHandler {

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

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("你的性别是" + this.target.getSex() + ",帮你找对象");
        return null;
    }
}
