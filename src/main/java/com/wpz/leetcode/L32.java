package com.wpz.leetcode;

import java.util.Stack;

/**
 * @author wangpengzhe
 * @description 最长有效括号
 * @date 2019/12/19 13:37
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("())(())"));
    }

    /**
     * 时间、空间复杂度 O(n)
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    /**
     * 时间复杂度 O(n),空间复杂度O(1)
     */
    public static int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left < right) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return max;
    }
}
