package com.DesignPattern23.factory.AbstractFactory;

import com.DesignPattern23.factory.Car;

/**
 * 默认的工厂
 */
public class DefaultFactory extends AbstractFactory{

    private AudiFactory defaultFactory = new AudiFactory();
    public Car getCar() {
        return defaultFactory.getCar();
    }


}
