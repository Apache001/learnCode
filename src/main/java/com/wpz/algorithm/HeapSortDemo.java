package com.wpz.algorithm;

/**
 * @author wangpengzhe
 * @description 堆排序
 * @date 2019/12/23 16:12
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class HeapSortDemo {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 3, 4, 6};
        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    private static void heapSort(int[] arr) {
        buildHeap(arr, arr.length);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i - 1);
        }
    }

    private static void buildHeap(int[] arr, int length) {
        //完全二叉树只有 0-arr.length/2-1 节点有叶子节点
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, length);
        }
    }

    private static void adjust(int[] arr, int i, int length) {
        //左孩子节点下标
        int left = 2 * i + 1;
        //右孩子节点下标
        int right = 2 * i + 2;

        int max = i;
        if (left < length && arr[left] > arr[i]) {
            max = left;
        }
        if (right < length && arr[right] > arr[max]) {
            max = right;
        }
        //获取左孩子、右孩子、根节点最大值，如果最大值等于当前值不用交换，否则将最大值和当前节点数据交换，递归调整下面节点
        if (max == i) {
            return;
        } else {
            swap(arr, i, max);
        }

        adjust(arr, max, length);
    }

    private static void swap(int[] arr, int i, int max) {
        int tmp = arr[max];
        arr[max] = arr[i];
        arr[i] = tmp;
    }
}
