package com.wpz.algorithm;

/**
 * @author wangpengzhe
 * @description 循环队列
 * @date 2019/11/22 17:12
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class CircleQueueDemo {

    public static void main(String[] args) {

    }

    private Integer[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    CircleQueueDemo(int capacity) {
        items = new Integer[capacity];
        n = capacity;
    }

    /**
     * 入队  队满条件 (tail+1)%==head
     *
     * @return int
     */
    private boolean enqueue(int data) {
        if ((tail + 1) % n == head) {
            throw new IllegalArgumentException("队列已满");
        }
        items[tail++] = data;
        return true;
    }

    /**
     * 出队  队空条件 head==tail
     *
     * @return int
     */
    private int dequeue() {
        if (head == tail) {
            return -1;
        }
        int res = items[head];
        head = (head + 1) % n;
        return res;
    }
}
