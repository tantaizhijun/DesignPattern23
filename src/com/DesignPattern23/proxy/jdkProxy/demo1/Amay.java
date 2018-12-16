package com.DesignPattern23.proxy.jdkProxy.demo1;

/**
 * 被代理人 女孩
 */
public class Amay implements Person {

    private String sex = "女";
    private String name = "amay";

    @Override
    public void findLove() {
        System.out.println("我是" + this.name +",我要找高富帅男孩");
    }

    @Override
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
