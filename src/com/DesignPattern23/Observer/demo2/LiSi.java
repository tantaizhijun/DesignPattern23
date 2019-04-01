package com.DesignPattern23.Observer.demo2;

import com.DesignPattern23.Observer.demo1.ILiSi;

public class LiSi implements Observer {

    //李斯是个观察者，看到韩非子活动，就知道要向秦始皇汇报
    public void update(String context) {
        System.out.println("李斯：看到韩非子活动，开始汇报");
        this.reportQinShiH();
        System.out.println("汇报完毕");
    }

    private void reportQinShiH() {
        System.out.println("李斯：报告陛下，韩非子有活动了");
    }
}
