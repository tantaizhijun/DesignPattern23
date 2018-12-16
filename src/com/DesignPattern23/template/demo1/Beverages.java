package com.DesignPattern23.template.demo1;

/**
 * 饮料类
 *  抽象类
 */
public abstract class Beverages {

    /**
     * 冲咖啡的方法
     */
    public final void create() {
        //1.烧水
        boilWrater();
        //2.洗杯子
        pourInCup();
        //3.冲泡
        brew();
    }

    public abstract void pourInCup();
    public abstract void brew();

    public void boilWrater() {
        System.out.println("烧水....");
    };
}
