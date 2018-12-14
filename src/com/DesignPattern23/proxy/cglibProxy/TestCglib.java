package com.DesignPattern23.proxy.cglibProxy;

public class TestCglib {

    public static void main(String[] args) {
        try {
            XiaoMing obj = (XiaoMing)new CglibMeiPo().getInstance(XiaoMing.class);
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
