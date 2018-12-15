package com.DesignPattern23.factory.AbstractFactory;

import com.DesignPattern23.factory.Bmw;
import com.DesignPattern23.factory.Car;

public class BmwFactory extends AbstractFactory{
    @Override
    protected Car getCar() {
        return new Bmw();
    }
}
