package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * @date 2019/11/26 16:17
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[p]);
                    list.add(nums[q]);
                    res.add(list);
                    //去重
                    while (p < q && nums[p] == nums[p + 1]) {
                        p++;
                    }
                    //去重
                    while (p < q && nums[q] == nums[q - 1]) {
                        q--;
                    }
                    p++;
                    q--;
                } else if (sum > 0) {
                    q--;
                } else {
                    p++;
                }
            }
        }
        return res;
    }
}
