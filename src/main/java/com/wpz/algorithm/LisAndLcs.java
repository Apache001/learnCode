package com.wpz.algorithm;

import static org.apache.commons.lang3.StringUtils.reverse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 添加说明记得一定要大于十个字符
 *
 * @author wangpengzhe
 * @date 2020/3/23 16:00
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class LisAndLcs {

    public static void main(String[] args) {
        String s1 = "aebcd";
        String s2 = "bdcae";
        int[][] length = getLength(s1, s2);
        printArr(length);

        // display(length, s1, s1.length(), s2.length(), new ArrayList<>());
    }

    private static void printArr(int[][] length) {
        for (int i = 0; i < length.length; i++) {
            for (int j = 0; j < length[0].length; j++) {
                System.out.print(length[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getLength(String x, String y) {
        int[][] a = new int[x.length() + 1][y.length() + 1];
        int[][] b = new int[x.length() + 1][y.length() + 1];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1] + 1;
                    b[i][j] = 1; //左上
                } else if (a[i - 1][j] >= a[i][j - 1]) {
                    a[i][j] = a[i - 1][j];
                    b[i][j] = 2;  //上
                } else {
                    a[i][j] = a[i][j - 1];
                    b[i][j] = 3;  //左
                }
            }
        }

        printArr(a);
        traceBack(a, x, y, x.length(), y.length(), "");
        //输出最长公共子序列
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println(a[x.length()][y.length()]);
        return b;
    }

    static Set<String> set = new HashSet<>();
    public static void traceBack(int[][] dp, String s1, String s2, int i, int j, String lcs_str) {

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs_str += s1.charAt(i - 1);
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else if (dp[i][j - 1] < dp[i - 1][j]) {
                    i--;
                } else { // 相等的情况；说明是相等
                    traceBack(dp, s1, s2, i - 1, j, lcs_str);
                    traceBack(dp, s1, s2, i, j - 1, lcs_str);
                    return;
                }
            }
        }
        set.add(reverse(lcs_str));

    }

    public static void display(int[][] arr, String s, int i, int j, List<Character> list) {
        if (i == 0 || j == 0) {
            return;
        }
        if (arr[i][j] == 1) {
            display(arr, s, i - 1, j - 1, list);
            System.out.print(s.charAt(i - 1) + " ");
        } else if (arr[i][j] == 2) {
            display(arr, s, i - 1, j, list);
        } else if (arr[i][j] == 3) {
            display(arr, s, i, j - 1, list);
        }
    }
}
