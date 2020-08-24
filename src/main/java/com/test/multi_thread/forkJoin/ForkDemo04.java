package com.test.multi_thread.forkJoin;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分拆  有返回值
 *      求和
 */
public class ForkDemo04 {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Integer> joinTask = pool.submit(new MyRecursiveTask(1, 10));

        try {
            System.out.println("finish:" + joinTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    static class MyRecursiveTask extends RecursiveTask<Integer> {

        private int beginValue;
        private int endValue;

        public MyRecursiveTask(int beginValue, int endValue) {
            this.beginValue = beginValue;
            this.endValue = endValue;
        }

        //方式1
//        @Override
//        protected Integer compute() {
//            if(endValue - beginValue != 0 ) {
//                int middleBalue = (endValue + beginValue)/2;
//                MyRecursiveTask action1 = new MyRecursiveTask(beginValue, middleBalue);
//                MyRecursiveTask action2 = new MyRecursiveTask(middleBalue + 1, endValue);
//                this.invokeAll(action1,action2);
//                return action1.join() + action2.join();
//            } else {
//                return endValue;
//            }
//        }

        //方式2
        @Override
        protected Integer compute() {
            if(endValue - beginValue > 2 ) {
                int middleBalue = (endValue + beginValue)/2;
                MyRecursiveTask action1 = new MyRecursiveTask(beginValue, middleBalue);
                MyRecursiveTask action2 = new MyRecursiveTask(middleBalue + 1, endValue);

                //todo invokeAll 具有阻塞特性
                this.invokeAll(action1,action2);
                return action1.join() + action2.join();
            } else {
                int sum = 0;
                for (int i = beginValue; i <= endValue ; i++) {
                    sum+=i;
                }
                return sum;
            }
        }
    }
}
