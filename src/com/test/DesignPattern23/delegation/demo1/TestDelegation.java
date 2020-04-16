package com.test.DesignPattern23.delegation.demo1;

/**
 * 测试委托模式
 *
 */
public class TestDelegation {

    public static void main(String[] args) {

        //委托人找人干活
        Dispatcher dispatcher = new Dispatcher(new Person1());

        dispatcher.doSomething();
    }
}
