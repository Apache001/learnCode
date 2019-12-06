package com.wpz.algorithm;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/12/6 11:17
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class StringMatchDemo {

    public static void main(String[] args) {
        System.out.println(BF("absafdbb", "a"));
    }

    /**
     * BF匹配算法 暴力匹配
     *
     * @param s 主串
     * @param p 模式串
     * @return int  匹配到的第一个字符索引
     */
    public static int BF(String s, String p) {
        if (s.length() < p.length()) {
            return -1;
        }

        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = i;
            for (int j = 0; j < p.length(); j++) {
                if (p.length() <= s.length() - i) {
                    if (s.charAt(j + i) != p.charAt(j)) {
                        index = -1;
                        break;
                    } else if (j == p.length() - 1) {
                        return index;
                    }
                } else {
                    return -1;
                }
            }
        }
        return index;
    }
}
