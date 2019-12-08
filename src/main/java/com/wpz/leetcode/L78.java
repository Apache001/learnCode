package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wpz
 * @Desctription: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @Date: Created in 2019/12/8 15:25
 */
public class L78 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(subsets2(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (res.size() > 0) {
                int k = res.size();
                for (int j = 1; j <= k; j++) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.addAll(res.get(k - j));
                    list1.add(nums[i]);
                    res.add(list1);
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            res.add(list);
        }
        res.add(new ArrayList<>());
        return res;
    }

    static List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        backtrace(nums, 0, new ArrayList<>());
        return res;
    }

    private static void backtrace(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(nums, i + 1, list);
            list.remove(list.size() - 1);
        }

    }
}
