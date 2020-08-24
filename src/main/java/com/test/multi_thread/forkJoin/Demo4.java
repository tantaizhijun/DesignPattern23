package com.test.multi_thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 *
 *  todo Runnable 有返回值
 */
public class Demo4 {

    public static void main(String[] args) {
        try {
            ForkJoinPool pool = new ForkJoinPool();
            User user = new User();
            MyRunnable runnable = new MyRunnable(user);
            ForkJoinTask<User> task = pool.submit(runnable, user);

            System.out.println("main1 :" + System.currentTimeMillis());

            System.out.println("----" + task.join().getName());


            System.out.println("main finish");

        }catch (Exception e){

        }

    }

    static class MyRunnable implements Runnable{

        private User user;

        public MyRunnable(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            user.setName("上岛咖啡就好");
        }
    }

    static class User{

        private String name;

        public User(String name) {
            this.name = name;
        }

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
