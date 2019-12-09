package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * @date 2019/12/5 19:32
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L10 {

//    '.' 匹配任意单个字符
//    '*' 匹配零个或多个前面的那一个元素

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*ac*a"));
    }

    static boolean matched = false;

    public static boolean isMatch(String s, String p) {
        rmatch(0, 0, s, p);
        return matched;
    }

    //todo
    private static void rmatch(int si, int pi, String s, String p) {
        if (matched) {
            return;
        }
        if (pi == p.length() - 1) {
            if (si == s.length() - 1) {
                matched = true;
            }
            return;
        }
        if (si == s.length() - 1) {
            matched = true;
            return;
        }
        if (p.charAt(pi) == '*') {
            for (int k = 0; k <= s.length() - si; k++) {
                rmatch(si + k, pi + 1, s, p);
            }
        } else if (p.charAt(pi) == '.') {
            rmatch(si, pi + 1, s, p);
            rmatch(si + 1, pi + 1, s, p);
        } else if (si < s.length() && s.charAt(si) == p.charAt(pi)) {
            rmatch(si + 1, pi + 1, s, p);
        } else if (pi < p.length()) {
            rmatch(si, pi + 1, s, p);
        }

    }
}
