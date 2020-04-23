package com.wpz.algorithm;

import com.sun.corba.se.spi.ior.iiop.MaxStreamFormatVersionComponent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 添加说明记得一定要大于十个字符
 *
 * @author wangpengzhe
 * @date 2020/2/25 13:13
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        getLongestSequence(s1, s2);
        System.out.println(maxValue);
        System.out.println(res);
    }
    private static int maxValue = 0;

    public static void getLongestSequence(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        maxValue = dp[l1][l2];
        printAll(dp, l1, l2, s1, s2, "");
    }

    static Set<String> res = new HashSet<>();

    public static void printAll(int[][] arr, int i, int j, String s1, String s2, String tmp) {
        // List<Character> list = new ArrayList<>();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                tmp += s1.charAt(i - 1);
                --i;
                --j;
            } else {
                if (arr[i - 1][j] > arr[i][j - 1]) {
                    --i;
                } else if (arr[i - 1][j] < arr[i][j - 1]) {
                    --j;
                } else {
                    printAll(arr, i, j - 1, s1, s2, tmp);
                    printAll(arr, i - 1, j, s1, s2, tmp);
                    return;
                }
            }
        }
        res.add(new StringBuffer(tmp).reverse().toString());
    }
}
