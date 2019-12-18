package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * @date 2019/12/18 13:24
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 8);
        System.out.println(ints[0] + "  " + ints[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int low = 0;
        int high = nums.length - 1;

        //二分查找第一个元素
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] != target)) {
                res[0] = middle;
                break;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] >= target) {
                high = middle - 1;
            }
        }

        if(res[0]==-1){
            return res;
        }
        //二分查找最后一个元素
        low = res[0];
        high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target && (middle == nums.length - 1 || nums[middle + 1] != target)) {
                res[1] = middle;
                break;
            } else if (nums[middle] <= target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            }
        }
        return res;
    }
}
