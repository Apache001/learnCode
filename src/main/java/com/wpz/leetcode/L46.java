package com.wpz.leetcode;

import static org.apache.commons.lang3.ArrayUtils.swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author wangpengzhe
 * @description 全排列
 * @date 2019/12/2 17:34
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L46 {

    public static void main(String[] args) {
        int[] nums = {1,1, 2, 3};
        //System.out.println(permute(nums));
        System.out.println(permute2(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(0, nums, list);
        return res;
    }

    /**
     * 回溯法
     *
     * @return void
     */
    public static void backtrack(int n, int[] nums, List<Integer> list) {
        if (nums.length == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrack(n + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        recur(nums,0,nums.length);
        return res;
    }

    public static void recur(int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            ArrayUtils.swap(nums, j, start);
            recur(nums, start + 1, end);
            ArrayUtils.swap(nums, j, start);
        }

    }
}
