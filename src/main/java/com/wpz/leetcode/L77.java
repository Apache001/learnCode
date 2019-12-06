package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * @date 2019/12/6 16:41
 */
public class L77 {

    public static void main(String[] args) {
        System.out.println(combine(2, 1));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtrace(1, n, k, new ArrayList<>());
        return res;
    }

    private static void backtrace(int start, int n, int k, List<Integer> list) {
        if (k < 0) {
            return;
        } else if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrace(i + 1, n, k - 1, list);
            list.remove(list.size() - 1);
        }
    }

}
