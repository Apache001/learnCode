package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 字符串转数字
 * @date 2019/11/28 13:53
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));

    }

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                if (first && str.charAt(i) == '-') {
                    first = false;
                    sb.append(str.charAt(i));
                } else if (first && str.charAt(i) == ' ') {
                    continue;
                } else if (first && str.charAt(i) == '+') {
                    first = false;
                } else if (first) {
                    return 0;
                } else if (!first) {
                    break;
                }
            } else {
                first = false;
                sb.append(str.charAt(i));
            }
        }

        if (sb.length() == 1 && sb.charAt(0) == '-' || sb.length() == 0) {
            return 0;
        }
        int res = 0;
        int start = sb.charAt(0);
        int m = start == '-' ? 1 : 0;
        for (int j = m; j < sb.length(); j++) {
            if (start == '-') {
                if (res * -1 <= Integer.MIN_VALUE + ((sb.charAt(j) - 48) * Math.pow(10, sb.length() - j - 1 ))) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (res >= Integer.MAX_VALUE-((sb.charAt(j) - 48) * Math.pow(10, sb.length() - j - 1 ))) {
                    return Integer.MAX_VALUE;
                }
            }
            res += (sb.charAt(j) - 48) * Math.pow(10, sb.length() - j - 1);
        }

        if (start == '-') {
            res *= -1;
        }

        return res;
    }
}
