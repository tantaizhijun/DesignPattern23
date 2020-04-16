package com.test.Other.producerAndConsumer;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个生产，多个消费。
 *      有问题呢
 */
public class TestDemo2 {


    public static ArrayList list = new ArrayList();

    public static void main(String[] args) {
        String str = new String("1");

        Consumer2 consumer1 = new Consumer2(str);
        Consumer2 consumer2 = new Consumer2(str);
        Product1 product1 = new Product1(str);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(consumer1);
        executorService.submit(consumer2);
        executorService.submit(product1);

    }

    /**
     * 消费者
     */
    static class Consumer2 implements Runnable{

        private String strLock;


        public Consumer2(String str) {
            this.strLock = str;
        }

        public void run() {
            while (true) {
                synchronized (strLock) {
                    try {
                        while (TestDemo2.list.isEmpty()) {
                            strLock.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + "消费：" + TestDemo2.list.remove(0)+ "size：" + TestDemo2.list.size());
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
     * 生产者
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
                        while (TestDemo2.list.size() >= 2) {
                            strLock.wait();
                        }
                        TestDemo2.list.add("1");
                        TestDemo2.list.add("2");
                        System.out.println(Thread.currentThread().getName() + " 生产者生产" +"size:" + TestDemo2.list.size());
                        Thread.sleep(1000);
                        strLock.notifyAll();

                    } catch (Exception e) {

                    }
                }
            }
        }
    }
}
