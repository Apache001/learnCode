package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/12/5 12:39
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L52 {

    public static void main(String[] args) {

        System.out.println(totalNQueens(8));

    }

    static int totalCount = 0;

    public static int totalNQueens(int n) {
        Integer[] queen = new Integer[n];
        backtrace(n, queen, 0);
        return totalCount;
    }

    private static void backtrace(int n, Integer[] queen, int row) {
        if (row == n) {
            totalCount++;
            return;
        }
        for (int column = 0; column < n; column++) {
            if (isOk(row, column, queen, n)) {
                queen[row] = column;
                backtrace(n, queen, row + 1);
                //回溯
                queen[queen.length - 1] = 0;
            }
        }
    }

    //判断是否有冲突
    private static boolean isOk(int row, int column, Integer[] queen, int n) {
        if (row == 0) {
            return true;
        }
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            //上方是否冲突
            if (queen[i] == column) {
                return false;
            }
            //左上角是否冲突
            if (leftUp >= 0) {
                if (queen[i] == leftUp) {
                    return false;
                }
            }
            //右上角是否冲突
            if (rightUp <= n) {
                if (queen[i] == rightUp) {
                    return false;
                }
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }
}
