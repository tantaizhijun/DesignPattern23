package com.test.DesignPattern23.Observer.demo2;

public class ZhangSan implements Observer {
    @Override
    public void update(String text) {
        System.out.println("张三也看到韩非子活动");
        this.report();
    }

    private void report(){
        System.out.println("张三看到韩非子活动，开始汇报");
    }
}
