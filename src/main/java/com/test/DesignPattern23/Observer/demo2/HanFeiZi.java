package com.test.DesignPattern23.Observer.demo2;

import com.test.DesignPattern23.Observer.demo1.IHanFeiZi;

import java.util.ArrayList;

public class HanFeiZi implements Observable, IHanFeiZi{

    //维护一个订阅者（监听者）列表，有活动时发布信息给每个人(监听者)
    private ArrayList<Observer> list = new ArrayList<>();

    //增加订阅者，增加监听者
    @Override
    public void addObserver(Observer observer) {
        this.list.add(observer);
    }

    //删除订阅者/删除监听者
    @Override
    public void deleteObserver(Observer observer) {
        this.list.remove(observer);
    }

    //发布信息/通知
    @Override
    public void notifyOberver(String text) {
        for (Observer observer:list) {
            observer.update(text);
        }
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子: 玩去了");
        this.notifyOberver("韩非子玩呢");
    }

    @Override
    public void eat() {
        System.out.println("韩非子: 吃饭呢！");
        this.notifyOberver("韩非子吃饭了");
    }


}
