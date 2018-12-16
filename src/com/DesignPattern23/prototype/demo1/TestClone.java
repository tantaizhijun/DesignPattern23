package com.DesignPattern23.prototype.demo1;

public class TestClone {

    public static void main(String[] args) {
        ConcreatePrototype cp = new ConcreatePrototype();
        cp.setAge(18);

        try{
            ConcreatePrototype clone = (ConcreatePrototype) cp.clone();
            System.out.println(clone.getAge());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
