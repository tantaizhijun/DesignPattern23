package com.test.multi_thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * 分拆  无返回值
 *
 *      TODO 为啥有时候打印不全呢?
 */
public class ForkDemo02 {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        //TODO invoke是同步执行
//        Void invoke = pool.invoke(new MyRecursiveAction(1, 10));

        //todo 使用submit 是异步执行
        ForkJoinTask<Void> joinTask = pool.submit(new MyRecursiveAction(1, 10));

        System.out.println("finish");
    }


    static class MyRecursiveAction extends RecursiveAction {

        private int beginValue;
        private int endValue;

        public MyRecursiveAction(int beginValue, int endValue) {
            super();
            this.beginValue = beginValue;
            this.endValue = endValue;
        }

        @Override
        public void compute() {
            System.out.println(Thread.currentThread().getName() + "==" + endValue + "==" + beginValue);
            if(endValue - beginValue > 2) {
                int middleNum = (beginValue + endValue) / 2 ;
                MyRecursiveAction action = new MyRecursiveAction(beginValue, middleNum);
                MyRecursiveAction action1 = new MyRecursiveAction(middleNum + 1, endValue);

                this.invokeAll(action,action1);

            } else {
                System.out.println("组合:" + beginValue + "-" + endValue);
            }
        }
    }
}
