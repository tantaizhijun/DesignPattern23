package com.DesignPattern23.factory.simpleFactory.demo1;

import com.DesignPattern23.factory.Car;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        //测试简单工厂
        Car car = new SimpleFactory().getCar("BMW");
        System.out.println("car name" + car.getName());
    }
}
