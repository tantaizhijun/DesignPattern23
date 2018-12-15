package com.DesignPattern23.factory.factoryMethod;

import com.DesignPattern23.factory.Car;

/**
 * 工厂接口
 * 定义了所有工厂的执行标准, 由具体工厂进行实现
 */
public interface Factory {

    Car getCar();

}
