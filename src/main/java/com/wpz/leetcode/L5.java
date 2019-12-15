package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * @date 2019/11/28 12:50
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
        // System.out.println("abc".substring(0,3));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int max = 1;
        int center = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            //回文串為奇數
            int ji = centExpend(s, i, i);
            int ou = centExpend(s, i, i + 1);
            if (max < Math.max(ji, ou)) {
                center = i;
                max = Math.max(ji, ou);
                flag = ji > ou;
            }
        }
        if (flag) {
            return s.substring(center - max / 2, center + max / 2 + 1);
        } else {
            return s.substring(center - (max - 1) / 2, center + max / 2 + 1);
        }
    }

    private static int centExpend(String s, int p, int q) {
        int left = p, right = q;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
