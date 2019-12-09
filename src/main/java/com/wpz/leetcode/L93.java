package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。  输入: "25525511135" 输出: ["255.255.11.135", "255.255.111.35"]
 * @date 2019/12/9 17:57
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L93 {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return res;
        }
        backtrace(s, 0, new StringBuilder(), 0);
        return res;
    }

    private static void backtrace(String s, int start, StringBuilder sb, int dotCount) {
        if (dotCount > 4) {
            return;
        }
        if (start == s.length() && dotCount == 4) {
            res.add(sb.toString().substring(1));
            return;
        }

        for (int i = start; i < s.length() && i - start < 3; i++) {
            String x = s.substring(start, i + 1);
            if (x.charAt(0) == '0' && x.length() > 1) {
                return;
            }
            if (Integer.parseInt(x) <= 255) {
                sb.append(".").append(x);
                backtrace(s, i + 1, sb, dotCount + 1);
                sb.delete(sb.lastIndexOf("."), sb.length());
            }
        }
    }
}
