package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 数字只允许出现一次
 * @date 2019/12/4 17:06
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L40 {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};

        System.out.println(combinationSum2(candidates, 8));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtrace(0, candidates, target, list);
        return res;
    }

    public static void backtrace(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                backtrace(i + 1, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
