package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 找出数组中的重复元素  长度为n的数组 所有数字都在0-n-1范围内
 * @Date: Created in 2019/12/7 16:13
 */
public class Question3 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(getDuplicate(nums));
    }

    /**
     * 数组长度为n，并且值都在0-n-1内，所以如果没有重复的话，排序后所有
     * 数字都和下标值对应
     * 时间复杂度O(n),空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int getDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, nums[i], i);
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}
