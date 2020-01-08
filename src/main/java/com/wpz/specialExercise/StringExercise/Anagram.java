package com.wpz.specialExercise.StringExercise;

/**
 * 有效的字母异位词
 *
 * @author wangpengzhe
 * @date 2019/12/30 13:38
 */
public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "angaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        //两个字符串中每个字母出现的次数一样 则为true
        int[] a = new int[128];
        int[] b = new int[128];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
            b[t.charAt(i)]++;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
