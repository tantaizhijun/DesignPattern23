package com.DesignPattern23.Observer.demo1;

/**
 * 观察者 李斯 的抽象接口
 */
public interface ILiSi {

    //一旦别人有行动，自己也要行动起来
    public void update(String context);
}
