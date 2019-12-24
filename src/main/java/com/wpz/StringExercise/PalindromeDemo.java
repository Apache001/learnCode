package com.wpz.StringExercise;


/**
 * @author wangpengzhe
 * @description 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @date 2019/12/24 16:02
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class PalindromeDemo {

    public static void main(String[] args) {
//        输入: "A man, a plan, a canal: Panama"
//        输出: true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isCharOrNum(s.charAt(left))) {
                left++;
            }
            while (left < right && !isCharOrNum(s.charAt(right))) {
                right--;
            }
            if (left < right && isEqualsChar(Character.toLowerCase(s.charAt(left)), Character.toLowerCase(s.charAt(right)))) {
                left++;
                right--;
            } else if (left < right && !isEqualsChar(Character.toLowerCase(s.charAt(left)), Character.toLowerCase(s.charAt(right)))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEqualsChar(char a, char b) {
        if (a == b) {
            return true;
        }
        return false;
    }

    private static boolean isCharOrNum(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

}
