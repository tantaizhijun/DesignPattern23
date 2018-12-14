package com.DesignPattern23.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeiPo implements MethodInterceptor {

    //
    public Object getInstance(Class clazz) {
       //通过反射机制进行实例化
        Enhancer en = new Enhancer();
        //给他设置父类
        en.setSuperclass(clazz);
        //设置回调,回调invoke方法
        en.setCallback(this);
        return en.create();
    }

    //做的依然还是字节码重组来实现
    //但用户是无感知的
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        //dosomething before
        System.out.println("前置增强, 调用前执行一些事情");

        //这个obj的引用是由cglib给我们new出来的
        //是被代理人的子类,,继承了我们写的那个类
        //new子类之前,默认先调用super(),即先new父类,相当于简介持有类父类引用
        //改变子对对象的某些属性,可以间接操作到父类的属性
        proxy.invokeSuper(o,args);

        //dosomething after
        System.out.println("后置增强, 调用后执行一些事情");
        return null;
    }
}
