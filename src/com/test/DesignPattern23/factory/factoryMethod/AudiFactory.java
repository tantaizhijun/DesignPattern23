package com.test.DesignPattern23.factory.factoryMethod;

import com.test.DesignPattern23.factory.Audi;
import com.test.DesignPattern23.factory.Car;

public class AudiFactory implements Factory {

    @Override
    public Car getCar() {
        return new Audi();
    }
}
