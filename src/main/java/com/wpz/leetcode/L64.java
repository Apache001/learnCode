package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @date 2019/12/20 15:57
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L64 {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];

        int rowVal = 0;
        for (int i = 0; i < row; i++) {
            dp[i][0] = grid[i][0] + rowVal;
            rowVal = dp[i][0];
        }

        int columnVal = 0;
        for (int j = 0; j < column; j++) {
            dp[0][j] = grid[0][j] + columnVal;
            columnVal = dp[0][j];
        }

        //f(i,j) = min(f(i,j-1),f(i-1,j))
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][column - 1];
    }
}
