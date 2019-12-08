package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wpz
 * @Desctription: 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @Date: Created in 2019/12/8 16:12
 */
public class L90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrace(nums, 0, new ArrayList<>());
        return res;
    }

    private static void backtrace(int[] nums, int start, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrace(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
