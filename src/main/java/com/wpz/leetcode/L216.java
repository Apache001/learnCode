package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wpz
 * @Desctription: 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字
 * @Date: Created in 2019/12/11 22:17
 */
public class L216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0) {
            return res;
        }

        dfs(1, k, n, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(int start, int k, int n, int sum, ArrayList<Integer> list) {
        if (list.size() == k && sum == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == k) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            sum += i;
            if (sum <= n) {
                dfs(i + 1, k, n, sum, list);
            }
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
