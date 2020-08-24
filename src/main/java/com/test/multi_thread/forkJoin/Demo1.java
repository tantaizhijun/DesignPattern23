package com.test.multi_thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 没有fork分解的任务,
 */
public class Demo1 {

    ///**
// * forkJoinPool 提供的功能是一个任务池
// *  执行任务的是ForkJoinTask类，该类抽象，使用其子类RecursiveAction子类实现具体功能
// *
// *  注: RecursiveAction 执行的任务是具有无返回值的，仅执行一次任务
// */
    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new MyRecursiveAction());
        System.out.println("main finish");


    }

    /**
     * 实现RecursiveAction类，覆写compute方法，实现自己的任务
     *
     * todo : RecursiveAction 执行的任务是具有无返回值的，仅执行一次任务
     */
    static class MyRecursiveAction extends RecursiveAction{

        @Override
        public void compute() {

            //todo 为啥加了try-catch就不执行了?
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("compute run");
        }
    }
}
