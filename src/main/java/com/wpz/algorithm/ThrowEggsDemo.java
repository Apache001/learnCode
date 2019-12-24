package com.wpz.algorithm;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/12/24 13:02
 */
public class ThrowEggsDemo {

    public static void main(String[] args) {
        System.out.println(superEggDrop2(3, 14));
    }

    private static int superEggDrop(int eggs, int levels) {
        if (eggs == 1) {
            return levels;
        }
        if (levels == 0) {
            return 0;
        }

        int[][] dp = new int[eggs + 1][levels + 1];

        for (int i = 2; i < levels + 1; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        for (int i = 2; i < eggs + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 2; i < eggs + 1; i++) {
            for (int j = 2; j < levels + 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < j; k++) {
                    min = Math.min(min, Math.max(dp[i][j - k] + 1, dp[i - 1][k - 1] + 1));
                }
                dp[i][j] = min;
            }
        }
        return dp[eggs][levels];
    }


    private static int superEggDrop2(int eggs, int levels) {
        if (eggs == 1) {
            return levels;
        }
        if (levels == 0) {
            return 0;
        }

        int[][] dp = new int[eggs + 1][levels + 1];

        int m = 0;
        while (dp[eggs][m] < levels) {
            m++;
            for (int k = 1; k <= eggs; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }
}
