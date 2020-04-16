package com.test.Other.producerAndConsumer;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个生产者 一个消费者
 */
public class TestDemo1 {


    public static ArrayList list = new ArrayList();

    public static void main(String[] args) {
        String str = new String("1");

        Consumer1 consumer1 = new Consumer1(str);
        Product1 product1 = new Product1(str);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(consumer1);
        executorService.submit(product1);

    }

    /**
     * 消费者1个
     */
    static class Consumer1 implements Runnable{

        private String strLock;


        public Consumer1(String str) {
            this.strLock = str;
        }

        public void run() {
            while (true) {
                synchronized (strLock) {
                    try {
                        while (TestDemo1.list.isEmpty()) {
                            strLock.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + "消费：" + TestDemo1.list.remove(0) + TestDemo1.list.size());
                        Thread.sleep(1000);
                        strLock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    /**
     * 生产者 1 个
     */

    static class Product1 implements Runnable{


        private String strLock;


        public Product1(String str) {
            this.strLock = str;
        }

        public void run() {
            while (true) {
                synchronized (strLock) {
                    try {
                        while (!TestDemo1.list.isEmpty()) {
                            strLock.wait();
                        }
                        TestDemo1.list.add("1");
                        System.out.println(Thread.currentThread().getName() + " 生产者生产" +"size:" + TestDemo1.list.size());
                        Thread.sleep(1000);
                        strLock.notifyAll();

                    } catch (Exception e) {

                    }
                }
            }
        }
    }
}
