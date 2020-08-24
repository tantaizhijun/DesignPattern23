package com.test.multi_thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分拆  有返回值
 *      字符串拼接 1-20
 */
public class ForkDemo03 {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<String> joinTask = pool.submit(new MyRecursiveTask(1, 20));

        System.out.println("finish:" + joinTask.join());
    }


    static class MyRecursiveTask extends RecursiveTask<String> {

        private int beginValue;
        private int endValue;

        public MyRecursiveTask(int beginValue, int endValue) {
            this.beginValue = beginValue;
            this.endValue = endValue;
        }

        @Override
        protected String compute() {
            if(endValue - beginValue > 2 ) {
                int middleBalue = (endValue + beginValue)/2;
                MyRecursiveTask action1 = new MyRecursiveTask(beginValue, middleBalue);
                MyRecursiveTask action2 = new MyRecursiveTask(middleBalue + 1, endValue);
                this.invokeAll(action1,action2);
                return action1.join() + action2.join();
            } else {
                String str = "";
                for (int i = beginValue; i <=endValue ; i++) {
                    str = str + i;
                }
                System.out.println("else返回:" + str + ":" + beginValue + ":" +endValue);
                return str;
            }
        }
    }
}
