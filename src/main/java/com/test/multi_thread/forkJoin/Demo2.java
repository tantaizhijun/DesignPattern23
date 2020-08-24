package com.test.multi_thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 没有fork分解的任务
 *  todo RecursiveTask 有返回值   执行一个任务
 */
public class Demo2 {

    public static void main(String[] args) {
        try {
            MyRecursiveTask task = new MyRecursiveTask();

            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask forkJoinTask = pool.submit(task);

            System.out.println("main1 :" + task.get());

            //get() 和 join() 都可以获取返回值，区别是异常的处理上
            //get()方法出现可以在 主线程catch里捕获，join则直接抛出。
            //System.out.println(forkJoinTask.hashCode() + " " + forkJoinTask.get());
            System.out.println(forkJoinTask.hashCode() + " " + forkJoinTask.join());

            System.out.println("main2 : " + System.currentTimeMillis());

        }catch (Exception e){

        }

    }

    /**
     * RecursiveTask
     *  todo 具有返回值功能
     *
     */
    static class MyRecursiveTask extends RecursiveTask{

        @Override
        protected Object compute() {

            try {
                System.out.println("time " + System.currentTimeMillis());
                Thread.sleep(2000);
            }catch (Exception e){

            }
            System.out.println(" compute 完成");
            return "返回 100";
        }
    }
}
