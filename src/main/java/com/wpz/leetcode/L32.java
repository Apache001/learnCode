package com.wpz.leetcode;

import java.util.Stack;

/**
 * @Author: wpz
 * @Desctription: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @Date: Created in 2019/12/18 22:22
 */
public class L32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.size() == 0) {
                    continue;
                }
                max += 2;
                stack.pop();
            }
        }
        return max;
    }
}
