package com.wpz.leetcode;

/**
 * @Author: wpz
 * @Desctription: 不同路径
 * @Date: Created in 2019/12/19 21:37
 */
public class L62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(27, 10));
    }

    static int count = 0;

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, 0, 0, visited);
        return count;
    }

    //回溯法
    private static void dfs(int m, int n, int row, int column, boolean[][] visited) {
        if (row == m - 1 && column == n - 1) {
            count++;
            return;
        }
        if (isValid(m, n, row, column, visited)) {
            visited[row][column] = true;
            dfs(m, n, row + 1, column, visited);
            dfs(m, n, row, column + 1, visited);
            visited[row][column] = false;
        }
    }

    private static boolean isValid(int m, int n, int row, int column, boolean[][] visited) {
        if (row < m && column < n && !visited[row][column]) {
            return true;
        }
        return false;
    }


    //动态规划
    public static int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //f(i,j)表示到i,j为之走法数量， f(i,j)=f(i-1,j)+f(i,j-1)
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
