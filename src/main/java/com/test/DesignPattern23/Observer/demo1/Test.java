package com.test.DesignPattern23.Observer.demo1;

public class Test {
    public static void main(String[] args) throws Exception {
//        LiSi liSi = new LiSi();
//        HanFeiZi hanFeiZi = new HanFeiZi();
//        Spy spy = new Spy(hanFeiZi, liSi, "eat");
//        spy.start();
//
//        Spy spy2 = new Spy(hanFeiZi, liSi, "fun");
//        spy2.start();
//
//        Thread.sleep(1000);
//        hanFeiZi.eat();
//
//        Thread.sleep(1000);
//        hanFeiZi.haveFun();


        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.haveFun();
        hanFeiZi.eat();

    }
}
