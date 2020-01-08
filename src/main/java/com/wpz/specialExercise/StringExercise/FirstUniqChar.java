package com.wpz.specialExercise.StringExercise;

/**
 * 字符串中的第一个唯一字符
 *
 * @author wangpengzhe
 * @date 2019/12/30 17:54
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
