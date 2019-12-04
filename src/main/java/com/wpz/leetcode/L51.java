package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

/**
 * @author wangpengzhe
 * @description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * @date 2019/12/4 14:59
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L51 {

    public static void main(String[] args) {
        letterCombinations("27");
        System.out.println(res);
    }

    static List<String> res = new ArrayList<>();

    static String[] code = {"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        recurse(digits, sb);
        return res;
    }

    public static void recurse(String digits, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int d = digits.charAt(sb.length()) - '0';
        String s = code[d];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            recurse(digits, sb);
            //回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
