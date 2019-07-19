package com.Other.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * forkJoinPool 提供的功能是一个任务池
 *  执行任务的是ForkJoinTask类，该类抽象，使用其子类RecursiveAction子类实现具体功能
 */
public class Demo1 {


    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new MyRecursiveAction());


    }

    /**
     * 实现RecursiveAction类，覆写compute方法，实现自己的任务
     */
    static class MyRecursiveAction extends RecursiveAction{

        @Override
        public void compute() {
            System.out.println("compute run");
        }
    }
}
