package com.Other.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Demo2 {

    public static void main(String[] args) {
        try {
            MyRecursiveTask task = new MyRecursiveTask();

            System.out.println(task.hashCode());
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask forkJoinTask = pool.submit(task);

            System.out.println("main 1" + System.currentTimeMillis());

            //get() 和 join() 都可以获取返回值，区别是异常的处理上
            //get()方法出现可以在主线程catch里捕获，join则直接抛出。
            //System.out.println(forkJoinTask.hashCode() + " " + forkJoinTask.get());
            System.out.println(forkJoinTask.hashCode() + " " + forkJoinTask.join());

            System.out.println("main 2" + System.currentTimeMillis());

        }catch (Exception e){

        }

    }

    /**
     * RecursiveTask具有返回值功能
     */
    static class MyRecursiveTask extends RecursiveTask{

        @Override
        protected Object compute() {

            try {
                System.out.println("time " + System.currentTimeMillis());
                Thread.sleep(2000);
            }catch (Exception e){

            }
            return "返回 100";
        }
    }
}
