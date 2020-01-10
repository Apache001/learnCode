package com.wpz.specialExercise.stackAndqueueExercise;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 有序矩阵中第K小的元素 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。 请注意，它是排序后的第k小元素，而不是第k个元素
 *
 * @author wangpengzhe
 * @date 2020/1/8 20:26
 */
public class KthSmallest {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2},
            {1, 3}
        };
        System.out.println(kthSmallest(matrix, 2));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparing(o -> -o));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) {
                     maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();
    }
}
