package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * @date 2019/12/5 19:32
 */
public class L10 {

//    '.' 匹配任意单个字符
//    '*' 匹配零个或多个前面的那一个元素

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*ac*a"));
    }


    public static boolean isMatch(String s, String p) {
        if (p.length() <= 0) {
            return s.length() <= 0;
        }
        boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        } else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }


}
