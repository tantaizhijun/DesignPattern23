package com.test.DesignPattern23.factory.AbstractFactory;

import com.test.DesignPattern23.factory.Bmw;
import com.test.DesignPattern23.factory.Car;

public class BmwFactory extends AbstractFactory{
    @Override
    protected Car getCar() {
        return new Bmw();
    }
}
