package com.test.DesignPattern23.factory.AbstractFactory;

import com.test.DesignPattern23.factory.Car;

/**
 * 抽象工厂模式
 *
 * 定义一个工厂抽象类
 *  负责从具体的工厂实现中生成产品
 */
public abstract class AbstractFactory {
    protected abstract Car getCar();

    /**
     * 这段代码以后就是 动态配置 的功能
     *   具体的业务逻辑由具体的工厂(如AudiFactory)实现进行完成
     * @param name
     * @return
     */
    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new BmwFactory().getCar();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new AudiFactory().getCar();
        } else {
            System.out.println("无法生产对应汽车产品");
            return null;
        }

    }
}
