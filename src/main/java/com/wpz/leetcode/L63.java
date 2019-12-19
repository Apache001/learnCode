package com.wpz.leetcode;

/**
 * @Author: wpz
 * @Desctription: 不同路径2
 * @Date: Created in 2019/12/19 22:13
 */
public class L63 {

    public static void main(String[] args) {
//        int[][] obstacleGrid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };

        int[][] obstacleGrid = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}};

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][column - 1] == 1) {
            return 0;
        }
        //f(i,j)表示到i,j为之走法数量， f(i,j)=f(i-1,j)+f(i,j-1) i-1,j;i,j-1都不是障碍物
        //f(i,j)=f(i-1,j)  i,j-1是障碍物
        //f(i,j)=f(i,j-1) i-1,j是障碍物
        //f(i,j)=0 i,j-1;i-1,j都是障碍物
        //f(i,j)=0, i,j是障碍物
        int[][] dp = new int[row][column];
        dp[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < row) {
                    dp[i][0] = 0;
                    i++;
                }
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < column; j++) {
            if (obstacleGrid[0][j] == 1) {
                while (j < column) {
                    dp[0][j] = 0;
                    j++;
                }
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (obstacleGrid[i][j - 1] != 1 && obstacleGrid[i - 1][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else if (obstacleGrid[i][j - 1] == 1) {
                    dp[i][j] = dp[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == 1) {
                    dp[i][j] = dp[i][j - 1];
                } else if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[row - 1][column - 1];
    }
}
