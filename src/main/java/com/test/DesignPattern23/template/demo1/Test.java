package com.test.DesignPattern23.template.demo1;

public class Test {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.create();

        System.out.println("咖啡完成");

        Tea tea = new Tea();
        tea.create();
        System.out.println("tea完成");
    }
}
