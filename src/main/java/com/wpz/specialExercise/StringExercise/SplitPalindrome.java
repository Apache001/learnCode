package com.wpz.specialExercise.StringExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 * @date 2019/12/24 17:18
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class SplitPalindrome {

    public static void main(String[] args) {
        partition("aab");
        System.out.println(res);
    }

    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }

        backtrace(s, new ArrayList<>());

        return res;
    }

    private static void backtrace(String s, ArrayList<String> list) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
        }
        String str;
        for (int i = 1; i <= s.length(); i++) {
            str = s.substring(0, i);
            if (isPalindrome(str)) {
                list.add(str);
                backtrace(s.substring(i, s.length()), list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
