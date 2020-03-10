package com.wpz.algorithm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 添加说明记得一定要大于十个字符
 *
 * @author wangpengzhe
 * @date 2020/3/4 13:28
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new First());
        a.setName("线程1");
        a.start();
        Thread b = new Thread(new Second());
        b.setName("线程2");
        b.start();

    }


    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    static int count = 0;

    static class First implements Runnable {

        @Override
        public void run() {
            while (count < 10) {
                try {
                    lock.lock();

                    System.out.println(Thread.currentThread().getName() + "->" + count);
                    count++;
                    condition1.await();
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class Second implements Runnable {

        @Override
        public void run() {
            while (count < 10) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "->" + count);
                    count++;
                    condition1.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }
}
