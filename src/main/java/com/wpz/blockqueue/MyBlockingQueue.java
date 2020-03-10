package com.wpz.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列
 *
 * @author wangpengzhe
 * @date 2020/3/9 18:43
 */
public class MyBlockingQueue<E> {

    public static void main(String[] args) {

    }

    Object[] items;
    int takeIndex;
    int putIndex;
    final ReentrantLock lock;
    private static int count = 0;
    private final Condition notEmpty;
    private final Condition notFull;

    public MyBlockingQueue(int capacity) {
        items = new Object[capacity];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        count = capacity;
    }

    public void put(E val) {

        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putIndex++] = val;
            if (putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            notEmpty.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public E offer() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            @SuppressWarnings("unchecked")
            E res = (E) items[takeIndex];
            items[takeIndex--] = null;
            count--;
            notFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }
}
