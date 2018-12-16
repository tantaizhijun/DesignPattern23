package com.DesignPattern23.prototype.demo1;

/**
 * 原型类
 *  实现原型接口,重写clone()方法
 */
public class Prototype implements Cloneable{

    /**
     * 重写clone()方法, 直接调用父类的clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //注: clone虽然也是产生一个具有相同功能的对象,,但走的不是原型的构造方法


}
