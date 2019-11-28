package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/11/28 17:39
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L27 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }
}
