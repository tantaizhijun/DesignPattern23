package com.DesignPattern23.factory.factoryMethod;

import com.DesignPattern23.factory.simpleFactory.demo1.Audi;
import com.DesignPattern23.factory.simpleFactory.demo1.Car;

public class AudiFactory implements Factory {

    @Override
    public Car getCar() {
        return new Audi();
    }
}
