package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 返回 s 所有可能的分割方案
 * @date 2019/12/10 13:47
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L131 {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }


    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        backtrace( s, new ArrayList<>(), "");
        return res;
    }


    private static void backtrace(String str, List<String> list, String s) {
        if (str == null || str.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            s = str.substring(0, i);
            if (isHuiwen(s)) {
                list.add(s);
                backtrace(str.substring(i, str.length()), list, s);
                list.remove(list.size()-1);
            }
        }
    }


    private static boolean isHuiwen(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
