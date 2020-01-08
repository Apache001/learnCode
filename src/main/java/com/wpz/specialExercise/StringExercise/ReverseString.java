package com.wpz.specialExercise.StringExercise;

/**
 * 反转字符串
 *
 * @author wangpengzhe
 * @date 2019/12/30 18:11
 */
public class ReverseString {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
