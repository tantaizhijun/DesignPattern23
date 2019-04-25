package com.Other.scheduledExecutorService;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 使用Callable接口 进行任务延迟运行，具有返回值
 */
public class Demo1 {

    public static void main(String[] args) {
        try {
            ArrayList<Callable> list = new ArrayList();

            list.add(new MyCallableA());
            list.add(new MyCallableB());

            //创建一个单任务的计划任务执行池
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            //第二个参数 4L 是延迟运行的时间
            ScheduledFuture futureA = executor.schedule(list.get(0), 4L, TimeUnit.SECONDS);
            ScheduledFuture futureB = executor.schedule(list.get(1), 4L, TimeUnit.SECONDS);

            System.out.println("1: " + System.currentTimeMillis());

            //get()方法具有阻塞作用
            System.out.println("A 返回：" + futureA.get());
            System.out.println("B 返回：" + futureB.get());
            System.out.println("main end  " + System.currentTimeMillis());


            /**
             * 有时打印
             * call a beginpool-1-thread-1
             * call a end
             * call b beginpool-1-thread-1
             * call b end
             *
             * A 返回：return A
             * B 返回：return B
             * main end
             */

            /**
             *  有时打印
             * call a beginpool-1-thread-1
             * call a end
             * A 返回：return A
             *
             * call b beginpool-1-thread-1
             * call b end
             * B 返回：return B
             * main end
             */

        }catch (Exception e){

        }

    }



    static class MyCallableA implements Callable<String>{


        public String call() throws Exception{
            System.out.println("call a begin" + Thread.currentThread().getName() + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("call a end  "+ Thread.currentThread().getName() + System.currentTimeMillis());
            return "return A";
        }
    }

    static class MyCallableB implements Callable<String>{


        public String call() throws Exception {
            System.out.println("call b begin" + Thread.currentThread().getName() + System.currentTimeMillis());
            System.out.println("call b end  "+ Thread.currentThread().getName() + System.currentTimeMillis());
            return "return B";
        }
    }
}
