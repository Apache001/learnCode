package com.wpz.specialExercise.arrayExercise;

import java.util.Random;

/**
 * 打乱数组
 *
 * @author wangpengzhe
 * @date 2020/1/6 19:35
 */
public class shuffleArray {

    private static int[] arr;
    private static Random rand = new Random();
    private static int[] original;

    public static void main(String[] args) {

    }

    public shuffleArray(int[] nums) {
        arr = new int[nums.length];
        original = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            original[i] = nums[i];
        }
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int length = arr.length;
        for (int i = length; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
        return arr;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
