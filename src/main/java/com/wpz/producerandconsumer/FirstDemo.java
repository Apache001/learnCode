package com.wpz.producerandconsumer;

import java.util.concurrent.TimeUnit;

/**
 * 使用 wait、notify
 *
 * @author wangpengzhe
 * @date 2020/3/9 18:18
 */
public class FirstDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Producer());
        t1.start();
        Thread t2 = new Thread(new Consumer());
        t2.start();
    }

    static final String LOCK = "lock";
    static int count = 0;
    static int FULL = 3;

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }

            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
