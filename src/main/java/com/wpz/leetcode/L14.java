package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 最长公共前缀
 * @date 2019/12/9 13:41
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L14 {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println("a".substring(0,0));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].contains(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
