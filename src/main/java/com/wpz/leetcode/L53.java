package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @date 2019/11/29 17:11
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L53 {

    public static void main(String[] args) {
        int[] nums = {-2, -1, 1, 3, -6};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (tmp > max) {
                max = tmp;
            }
            if (tmp <= 0) {
                tmp = 0;
            }

        }
        return max;
    }
}
