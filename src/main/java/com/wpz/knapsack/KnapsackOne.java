package com.wpz.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * 0/1 背包
 *
 * @author wangpengzhe
 * @date 2020/1/17 10:38
 */
public class KnapsackOne {

    public static void main(String[] args) {
        int[] v = {0, 2, 4, 3, 7};
        int[] w = {0, 2, 3, 5, 5};
//        maxValueOfBag(10, 4, w, v);
//        System.out.println(res);

        System.out.println(ks2(10, 4, w, v));
        System.out.println(select);
    }

    /*
     * k个物品，每个物品重量wi,价值vi ,背包容量为c，装满背包的最大价值
     */

    static int res = Integer.MIN_VALUE;

    /**
     * @param c 背包容量
     * @param n 物品个数
     * @param weight 每个物品重量数组
     * @param value 每个物品价值数组
     */
    public static int maxValueOfBag(int c, int n, int[] weight, int[] value) {
        backtrace(0, weight, value, 0, 0, c, n);
        return res;
    }

    /**
     * @param i 第i个物品
     * @param w 物品重量
     * @param v 物品价值
     * @param c 背包容量
     * @param n 物品个数
     */
    public static void backtrace(int i, int[] w, int[] v, int sumValue, int sumWeight, int c, int n) {
        if (sumWeight == c || i == n) {
            if (sumValue > res) {
                res = sumValue;
            }
            return;
        }
        backtrace(i + 1, w, v, sumValue, sumWeight, c, n);
        if (w[i] + sumWeight <= c) {
            backtrace(i + 1, w, v, sumValue + v[i], sumWeight + w[i], c, n);
        }
    }


    /**
     * 自顶向下递归
     *
     * @param c 当前背包剩余重量
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param i 第i个物品
     * @return int   最大价值
     */
    public static int ks(int c, int[] w, int[] v, int i) {
        int result = 0;
        if (c == 0 || i == 0) {
            result = 0;
        } else if (w[i] > c) {
            result = ks(c, w, v, i - 1);
        } else {
            result = Math.max(ks(c, w, v, i - 1), ks(c - w[i], w, v, i - 1) + v[i]);
        }

        return result;
    }


    static List<Integer> select = new ArrayList<>();

    public static int ks2(int c, int n, int[] w, int[] v) {
        //dp[i][j] i个物品背包容量j的最大价值
        int[][] dp = new int[n + 1][c + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= c; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                //第i个物品放进去超重，dp[i][j]=[i-1][j]  第i-1个物品的最大价值
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //第i个物品可以放进去 dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        return dp[n][c];
    }
}
