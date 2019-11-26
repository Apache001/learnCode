package com.wpz.leetcode;

import java.util.Arrays;

/**
 * @author wangpengzhe
 * @description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * @date 2019/11/26 18:05
 */
public class L16 {

    public static void main(String[] args) {
        int[] nums = {-3, -2, -5, 3, -4};
        System.out.println(threeSumClosest(nums, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (target > sum) {
                    l++;
                } else if (target < sum) {
                    r--;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
