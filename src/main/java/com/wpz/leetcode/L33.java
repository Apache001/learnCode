package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 搜索旋转排序数组
 * @date 2019/12/18 16:43
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L33 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] >= nums[low]) { //旋转点在middle右边，左边是升序数组
                if (nums[middle] > target && nums[low] <= target) {
                    high = middle - 1;
                } else {
                    low = middle + 1;

                }
            } else {
                if (nums[middle] <= target && nums[high] >= target) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
}
