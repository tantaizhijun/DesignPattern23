package com.Other.scheduledExecutorService;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 使用Callable接口 进行任务延迟运行，具有返回值
 */
public class Demo2 {

    public static void main(String[] args) {
        try {
            ArrayList<Callable> list = new ArrayList();

            list.add(new MyCallableA());
            list.add(new MyCallableB());

            //使用一个同时运行 corePoolSize 个任务个数的任务执行池，参数指定为2，
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

            ScheduledFuture futureA = executor.schedule(list.get(0), 1L, TimeUnit.SECONDS);
            ScheduledFuture futureB = executor.schedule(list.get(1), 1L, TimeUnit.SECONDS);

            //get()方法具有阻塞作用
            System.out.println("1: " + System.currentTimeMillis());
            System.out.println("A 返回：" + futureA.get());
            System.out.println("B 返回：" + futureB.get());
            System.out.println("main end  " + System.currentTimeMillis());


            /**
             * 1: 1554003938720
             * call a beginpool-1-thread-11554003939725
             * call b beginpool-1-thread-21554003939725
             * call b end  pool-1-thread-21554003939725
             * call a end  pool-1-thread-11554003941729
             * A 返回：return A
             * B 返回：return B
             * main end  1554003941729
             */



        }catch (Exception e){

        }

    }



    static class MyCallableA implements Callable<String>{


        public String call() throws Exception{
            System.out.println("call a begin" + Thread.currentThread().getName() + " "+ System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("call a end  "+ Thread.currentThread().getName() + " " + System.currentTimeMillis());
            return "return A";
        }
    }

    static class MyCallableB implements Callable<String>{


        public String call() throws Exception {
            System.out.println("call b begin" + Thread.currentThread().getName() + " "+ System.currentTimeMillis());
            System.out.println("call b end  "+ Thread.currentThread().getName() + " "+ System.currentTimeMillis());
            return "return B";
        }
    }
}
