package com.test.Other.scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Desc TODO
 * @Auth alibobo
 * @Date 2020-04-20 14:16
 **/
public class Test {
    private final static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    int[] s = new int[1];
                    System.out.println("OK");
                    System.out.println(s[1]); // 数组越界
                } catch (Throwable t) {
                    System.out.println("Error");
                }

            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
