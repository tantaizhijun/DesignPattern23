package com.Other.scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用 executor 的 scheduleAtFixedRate(）方法进行 周期性执行任务
 *  该方法返回的ScheduledFuture无法获得返回值，即不具有获取返回值功能，（Runnable接口不能返回值）
 *  schedule()方法可以获取返回值，
 *  因此当使用该方法实现重复运行任务时，需要结合Runnable，不要使用FutureTask类，因为FutureTask类不能实现重复运行的效果
 */
public class Demo4 {
    public static void main(String[] args) {

        try {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

            System.out.println("main begin " + Thread.currentThread().getName() + System.currentTimeMillis());

            //该方法有超时或不超时的情况，延迟2秒运行，，但如果一个任务执行了4秒，就会延迟到4秒立即执行，而不是等上一个4秒的任务完成后再延迟2秒
            executor.scheduleAtFixedRate(new MyRunnable(), 1, 2, TimeUnit.SECONDS);

            //该方法并没有超时或不超时的情况，delay的作用是下一个任务的开始时间与上一个任务结束时间的间隔
//            executor.scheduleWithFixedDelay(new MyRunnable(), 1, 2, TimeUnit.SECONDS);

            System.out.println("main end " + Thread.currentThread().getName() + System.currentTimeMillis());
        }catch (Exception e){

        }
    }


    static class MyRunnable implements Runnable{
        public void run() {
            try{
                System.out.println("call a begin" + Thread.currentThread().getName() + System.currentTimeMillis());
                Thread.sleep(4000);
                System.out.println("call a end  "+ Thread.currentThread().getName() + System.currentTimeMillis());
            }catch (Exception e){

            }
        }
    }
}
