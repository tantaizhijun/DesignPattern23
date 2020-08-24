package com.test.multi_thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 没有fork分解的任务
 *  todo RecursiveTask 有返回值  执行多个任务
 */
public class Demo3 {

    public static void main(String[] args) {
        try {
            ForkJoinPool pool = new ForkJoinPool();

            MyRecursiveTaskA task = new MyRecursiveTaskA();
            ForkJoinTask task_a = pool.submit(task);

            MyRecursiveTaskB taskB = new MyRecursiveTaskB();
            ForkJoinTask task_b = pool.submit(taskB);


            System.out.println("main1 :" + System.currentTimeMillis());

            //任务执行是异步  join方法却是同步的
            System.out.println(task_a.hashCode() + " " + task_a.join());
            System.out.println(task_b.hashCode() + " " + task_b.join());

            System.out.println("main finish");

        }catch (Exception e){

        }

    }

    /**
     * RecursiveTask
     *  todo 具有返回值功能
     *
     */
    static class MyRecursiveTaskA extends RecursiveTask{
        @Override
        protected Integer compute() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" computeA 完成");
            return 100;
        }
    }

    static class MyRecursiveTaskB extends RecursiveTask{
        @Override
        protected Integer compute() {
            System.out.println(" computeB 完成");
            return 200;
        }
    }
}
