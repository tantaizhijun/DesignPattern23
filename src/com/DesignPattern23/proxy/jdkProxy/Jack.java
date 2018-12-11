package com.DesignPattern23.proxy.jdkProxy;

/**
 * 被代理人 男孩
 */
public class Jack implements Person {

    private String sex = "男";
    private String name = "jack";

    @Override
    public void findLove() {
        System.out.println("我要找女孩");
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
