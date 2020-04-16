package com.test.DesignPattern23.delegation.demo1;

/**
 * 2号员工
 */
public class Person2 implements IDelegate {

    @Override
    public void doSomething() {
        System.out.println("2号干活去");
    }
}
