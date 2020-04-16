package com.test.DesignPattern23.factory.simpleFactory.demo1;

import com.test.DesignPattern23.factory.Audi;
import com.test.DesignPattern23.factory.Bmw;
import com.test.DesignPattern23.factory.Car;

/**
 * 简单工厂: 汽车工厂
 * 缺点: 每次更改需求,,都要修改工厂方法
 *
 * 还有,所有的产品(汽车)都在这一个工厂生产,,显然是不合理的
 * 应该每种类型的产品有自己的生产线才对
 */
public class SimpleFactory {
    /*
     * 实现统一管理,
     *  但是维护起来很麻烦,,有新需求扩展,,每次都要修改下面的代码
     *  动态配置的功能和业务逻辑混乱
     */
    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new Bmw();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new Audi();
        } else {
            System.out.println("无法生产对应产品");
            return null;
        }

    }
}
