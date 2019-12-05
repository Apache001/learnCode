package com.wpz.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sun.reflect.generics.tree.ReturnType;

/**
 * @author wangpengzhe
 * @description n皇后
 * @date 2019/12/4 19:55
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L51 {

    public static void main(String[] args) {

        System.out.println(solveNQueens(4));

    }

    static List<Integer[]> r = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        Integer[] queen = new Integer[n];
        backtrace(n, queen, 0);

        for (int i = 0; i < r.size(); i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int c = r.get(i)[j];
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (k == c) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
        }

        return res;
    }

    private static void backtrace(int n, Integer[] queen, int row) {
        if (row == n) {
            r.add(Arrays.copyOf(queen, queen.length));
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
