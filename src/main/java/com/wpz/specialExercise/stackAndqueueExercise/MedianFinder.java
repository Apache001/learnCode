package com.wpz.specialExercise.stackAndqueueExercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流的中位数
 *
 * @author wangpengzhe
 * @date 2020/1/8 14:47
 */
public class MedianFinder {

    public static void main(String[] args) {

    }

    /**
     * 小顶堆
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    /**
     * 大顶堆
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public MedianFinder() {

    }

    int count = 0;

    public void addNum(int num) {
        count++;
        //偶数插入到最小堆，并且大顶堆的最大元素小于小顶堆
        if (count % 2 == 0) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }

    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (maxHeap.peek() + maxHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek() / 1.0;
        } else {
            return minHeap.peek() / 1.0;
        }
    }
}
