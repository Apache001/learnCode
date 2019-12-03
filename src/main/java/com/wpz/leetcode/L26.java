package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 * @date 2019/11/28 16:41
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L26 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4, 6, 6, 6, 7, 7};
        System.out.println(removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[n] != nums[i]) {
                nums[++n] = nums[i];
            }
        }
        return n + 1;
    }
}
