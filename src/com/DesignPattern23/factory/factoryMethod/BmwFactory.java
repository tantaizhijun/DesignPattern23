package com.DesignPattern23.factory.factoryMethod;

import com.DesignPattern23.factory.Car;
import com.DesignPattern23.factory.Bmw;

public class BmwFactory implements Factory {

    @Override
    public Car getCar() {
        return new Bmw();
    }
}
