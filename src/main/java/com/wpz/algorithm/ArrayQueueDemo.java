package com.wpz.algorithm;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/11/22 16:03
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueueDemo arrayQueueDemo = new  ArrayQueueDemo(5);
        arrayQueueDemo.enqueue(1);
        arrayQueueDemo.enqueue(2);

        System.out.println(arrayQueueDemo.dequeue());
    }

    private Integer[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    ArrayQueueDemo(int capacity) {
        items = new Integer[capacity];
        n = capacity;
    }

    public boolean enqueue(int val) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            head = 0;
            tail = tail - head;
        }
        items[tail++] = val;
        return true;
    }

    public int dequeue() {
        if (head == tail) {
            return -1;
        }
        return items[head++];
    }

}
