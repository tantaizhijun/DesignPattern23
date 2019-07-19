package com.Other.scheduledExecutorService;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 执行队列里的任务
 */
public class Demo5 {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

        MyRunnable1 r1 = new MyRunnable1("A");
        MyRunnable1 r2 = new MyRunnable1("B");
        MyRunnable1 r3 = new MyRunnable1("C");
        MyRunnable1 r4 = new MyRunnable1("D");
        MyRunnable1 r5 = new MyRunnable1("E");
        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());
        System.out.println(r3.hashCode());
        System.out.println(r4.hashCode());
        System.out.println(r5.hashCode());

        executor.scheduleAtFixedRate(r1,10,2, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(r2,10,2, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(r3,10,2, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(r4,10,2, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(r5,10,2, TimeUnit.SECONDS);

        System.out.println("---");

        BlockingQueue<Runnable> queue = executor.getQueue();
        Iterator<Runnable> iterator = queue.iterator();
        while (iterator.hasNext()){
            Runnable next = iterator.next();
            System.out.println("队列中的runnable" + next);
        }

    }


    static class MyRunnable1 implements Runnable{

        private String name;
        public MyRunnable1(String name){
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println("run " + name + Thread.currentThread().getName());
        }
    }
}
