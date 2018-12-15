package com.DesignPattern23.delegation.demo1;

/**
 * 人员1号
 */
public class Person1 implements IDelegate {


    @Override
    public void doSomething() {
        System.out.println("1号干活去");
    }
}
