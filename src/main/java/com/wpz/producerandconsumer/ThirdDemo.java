package com.wpz.producerandconsumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition
 *
 * @author wangpengzhe
 * @date 2020/3/10 10:33
 */
public class ThirdDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Producer());
        t1.setName("生产者");
        t1.start();
        Thread t2 = new Thread(new Consumer());
        t2.setName("消费者");
        t2.start();
    }

    static ReentrantLock lock = new ReentrantLock();
    static Condition notFull = lock.newCondition();
    static Condition notEmpty = lock.newCondition();
    static int count = 0;
    static int full = 5;

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == full) {
                        notFull.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    notEmpty.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == 0) {
                        notEmpty.await();
                    }

                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    notFull.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
