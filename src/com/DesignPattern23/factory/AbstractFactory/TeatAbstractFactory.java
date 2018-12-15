package com.DesignPattern23.factory.AbstractFactory;

import com.DesignPattern23.factory.Car;

/**
 * 测试抽象工厂
 */
public class TeatAbstractFactory {
    public static void main(String[] args) {

        DefaultFactory d = new DefaultFactory();
        Car car = d.getCar("BMW");
        System.out.println("name:" + car.getName());

        DefaultFactory ff = new DefaultFactory();
        Car cc = ff.getCar("Audi");
        System.out.println("name:" + cc.getName());
    }

}
