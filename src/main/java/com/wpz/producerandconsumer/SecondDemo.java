package com.wpz.producerandconsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列
 *
 * @author wangpengzhe
 * @date 2020/3/9 18:26
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class SecondDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Producer());
        t1.start();
        Thread t2 = new Thread(new Consumer());
        t2.start();
    }

    private static final int MAX_CAPACITY = 10;
    private static ArrayBlockingQueue<Object> goods = new ArrayBlockingQueue<Object>(MAX_CAPACITY);

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                // 每隔 1000 毫秒生产一个商品
                try {
                    Thread.sleep(1000);

                    goods.put(new Object());
                    System.out.println("Produce goods, total: " + goods.size());
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                // 每隔 500 毫秒消费一个商品
                try {
                    Thread.sleep(500);

                    goods.take();
                    System.out.println("Consume goods, total: " + goods.size());
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

