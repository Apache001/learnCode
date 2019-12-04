package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。(candidates 中的数字可以无限制重复被选取) 输入: candidates = [2,3,6,7],
 * target = 7, 所求解集为: [ [7], [2,2,3] ]
 * @date 2019/12/4 15:47
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L39 {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        backtrace(0, candidates, target, list);
        return res;
    }

    private static void backtrace(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrace(i, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }


    }
}
