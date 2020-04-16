package com.test.DesignPattern23.template.demo1;

/**
 * 饮料类
 *  抽象类  类似一件工作的流程模板，具体的工作自己去实现
 */
public abstract class Beverages {

    /**
     * 完成工作的流程 方法模板，方法内部的制作，由各个具体工作具体实现
     */
    public final void create() {
        //1.烧水，无需自己实现了，都需要水
        boilWrater();

        //2.放入杯子中，具体放啥，自己实现
        pourInCup();

        //3.怎么制作，实现类具体实现
        brew();
    }

    public abstract void pourInCup();
    public abstract void brew();

    public void boilWrater() {
        System.out.println("烧水....");
    };
}
