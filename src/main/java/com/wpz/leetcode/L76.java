package com.wpz.leetcode;

/**
 * 最小覆盖子串
 *
 * @author wangpengzhe
 * @date 2020/1/15 15:05
 */
public class L76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] hash = new int[256];
        for (int i = 0; i < tArr.length; i++) {
            hash[tArr[i]]++;
        }

        int left = 0, count = 0;
        int max = s.length() + 1;
        String result = "";
        for (int right = 0; right < sArr.length; right++) {
            hash[sArr[right]]--;
            if (hash[sArr[right]] >= 0) {
                count++;
            }

            while (left < right && hash[sArr[left]] < 0) {
                hash[sArr[left]]++;
                left++;
            }

            if (count == tArr.length && max > right - left + 1) {
                max = right - left + 1;
                result = s.substring(left, right + 1);
            }
        }

        return result;
    }
}
