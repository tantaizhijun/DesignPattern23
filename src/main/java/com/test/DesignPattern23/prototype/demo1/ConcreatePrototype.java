package com.test.DesignPattern23.prototype.demo1;

/** 定义一个类
 *      集成原型类, 就具备了clone的方法
 */
public class ConcreatePrototype extends Prototype{

    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
