package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/12/8 14:51
 */
public class Question13 {
    public static void main(String[] args) {
        System.out.println(moveCount(4, 4, 5));
    }

    private static int moveCount(int m, int n, int k) {
        if (k < 0 || m <= 0 || n <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];

        return moveCountRec(m, n, 0, 0, k, visited);
    }

    private static int moveCountRec(int m, int n, int row, int column, int k, boolean[][] visited) {
        int count = 0;
        if (isValid(m, n, row, column, k, visited)) {
            visited[row][column] = true;
            count = 1 + moveCountRec(m, n, row, column + 1, k, visited) +
                    moveCountRec(m, n, row, column - 1, k, visited) +
                    moveCountRec(m, n, row + 1, column, k, visited) +
                    moveCountRec(m, n, row - 1, column, k, visited);
        }

        return count;
    }

    private static boolean isValid(int m, int n, int row, int column, int k, boolean[][] visited) {
        if (row >= 0 && row < m && column >= 0 && column < n && (getSum(row) + getSum(column)) <= k && !visited[row][column]) {
            return true;
        }

        return false;
    }

    public static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
