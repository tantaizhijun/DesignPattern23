package com.Other.scheduledExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用Runnable 创建无返回值的计划任务
 */
public class Demo3 {

    public static void main(String[] args) {
        List<Runnable> list = new ArrayList<Runnable>();
        list.add(new MyRunnableA());
        list.add(new MyRunnableB());

        System.out.println("1: " + System.currentTimeMillis());
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(list.get(0),0L, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(list.get(1),0L, TimeUnit.SECONDS);
        System.out.println("1: " + System.currentTimeMillis());


    }


    static class MyRunnableA implements Runnable{
        public void run() {
            try {
                System.out.println("call a begin" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("call a end  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }catch (Exception e){

            }
        }
    }

    static class MyRunnableB implements Runnable{
        public void run() {
            try {
                System.out.println("call b begin" + Thread.currentThread().getName() + " " + System.currentTimeMillis());

                System.out.println("call b end  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }catch (Exception e){

            }
        }
    }
}
