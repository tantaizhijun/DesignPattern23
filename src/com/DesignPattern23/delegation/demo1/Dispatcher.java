package com.DesignPattern23.delegation.demo1;

/**
 * 委托人
 */
public class Dispatcher implements IDelegate {

    IDelegate iDelegate;

    Dispatcher(IDelegate iDelegate) {
        this.iDelegate = iDelegate;
    }

    //虽然也有方法执行, 但工作职责不同
    @Override
    public void doSomething() {
        this.iDelegate.doSomething();
    }
}
