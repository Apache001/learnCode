package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 * @date 2019/11/29 16:53
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L70 {

    public static void main(String[] args) {
        System.out.println(climbStairs2(44));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int i = 1, j = 2;
        int res = 0;
        for (int k = 3; k <= n; k++) {
            res = i + j;
            i = j;
            j = res ;
        }
        return res;
    }
}
