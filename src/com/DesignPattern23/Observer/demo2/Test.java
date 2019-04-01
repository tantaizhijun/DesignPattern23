package com.DesignPattern23.Observer.demo2;

public class Test {

    public static void main(String[] args) {
        Observer liSi = new LiSi();
        Observer zhangSan = new ZhangSan();

        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(zhangSan);
        hanFeiZi.haveFun();


    }
}
