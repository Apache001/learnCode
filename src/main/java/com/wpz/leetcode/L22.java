package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @date 2019/12/6 10:37
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L22 {

    //    [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//     ]
    public static void main(String[] args) {
        generateParenthesis(2);
        System.out.println(res);
    }

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backtrace(0, 0, n, "");
        return res;
    }

    private static void backtrace(int left, int right, int n, String str) {
        if (left == right && left == n) {
            res.add(str);
            return;
        }

        if (left < n) {
            backtrace(left + 1, right, n, str + "(");
        }

        if (right < left) {
            backtrace(left, right + 1, n, str + ")");
        }
    }


}
