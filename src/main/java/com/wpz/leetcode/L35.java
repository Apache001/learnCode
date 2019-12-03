package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @date 2019/11/29 18:11
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L35 {

    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

}
