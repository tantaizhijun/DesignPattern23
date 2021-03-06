package com.test.DesignPattern23.factory.AbstractFactory;

import com.test.DesignPattern23.factory.Audi;
import com.test.DesignPattern23.factory.Car;

/**
 * 具体的业务封装
 */
public class AudiFactory extends AbstractFactory{


    @Override
    protected Car getCar() {
        return new Audi();
    }
}
