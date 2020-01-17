package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * @author wangpengzhe
 * @date 2020/1/15 14:23
 */
public class L438 {

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abcdacb", "abc");
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {

        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] hash = new int[26];

        for (int i = 0; i < pArr.length; ++i) {
            hash[pArr[i] - 'a']++;
        }

        // l 表示左指针
        // count 记录当前的条件，具体根据题目要求来定义
        List<Integer> results = new ArrayList<>();
        int l = 0, count = 0, pLength = p.length();

        for (int r = 0; r < sArr.length; ++r) {
            // 更新新元素在散列中的数量
            hash[sArr[r] - 'a']--;
            // 根据窗口的变更结果来改变条件值
            if (hash[sArr[r] - 'a'] >= 0) {
                count++;
            }

            // 如果当前条件不满足，移动左指针直至条件满足为止
            if (r > pLength - 1) {
                hash[sArr[l] - 'a']++;
                if (hash[sArr[l] - 'a'] > 0) {
                    count--;
                }
                l++;
            }

            if (count == p.length()) {
                results.add(l);
            }
        }

        return results;
    }
}
