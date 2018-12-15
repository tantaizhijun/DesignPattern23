package com.DesignPattern23.factory.factoryMethod;

import com.DesignPattern23.factory.Car;

/**
 * 测试工厂方法
 */
public class FactoryTest {

    public static void main(String[] args) {

        //工厂方法模式 各产品的生产商有自己的工厂实现
        //需要用户关心这个产品的生产商,
        //增加了代码的使用复杂度
        Factory factory = new AudiFactory();
        Car car = factory.getCar();
        System.out.println("car name:" + car.getName());

        Factory factory2 = new BmwFactory();
        Car car2 = factory2.getCar();
        System.out.println("car name:" + car2.getName());


        //改进...
        //抽象工厂模式 --->
    }
}
