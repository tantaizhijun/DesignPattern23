package com.DesignPattern23.template.demo1;

public class Coffee extends Beverages {

    @Override
    public void pourInCup() {
        System.out.println("将coffee放入杯中");
    }

    @Override
    public void brew() {
        System.out.println("加入牛奶和糖,");
    }
}
