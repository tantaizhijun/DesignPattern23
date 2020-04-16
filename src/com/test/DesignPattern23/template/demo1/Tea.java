package com.test.DesignPattern23.template.demo1;

public class Tea extends Beverages {

    @Override
    public void pourInCup() {
        System.out.println("将茶叶放入杯中");
    }

    @Override
    public void brew() {
        System.out.println("加热水冲泡茶叶");
    }
}
