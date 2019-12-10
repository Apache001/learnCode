package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 正则表达式匹配
 * @Date: Created in 2019/12/9 21:42
 */
public class Question19 {

    //TODO
    public static void main(String[] args) {
        System.out.println(match("ab", ".*c"));
    }

    private static boolean match(String s, String pattern) {
        if (s == null || pattern == null) {
            return false;
        }

        return matchCore(s, 0, pattern, 0);
    }

    private static boolean matchCore(String s, int sindex, String pattern, int pindex) {
        if (sindex == s.length() && pindex == pattern.length()) {
            return true;
        }
        if (sindex != s.length() && pindex == pattern.length()) {
            return false;
        }

        if ((pindex + 1 < pattern.length()) && pattern.charAt(pindex + 1) == '*') {
            if ((sindex != s.length()) && s.charAt(sindex) == pattern.charAt(pindex) || pattern.charAt(pindex) == '.') {
                return matchCore(s, sindex, pattern, pindex + 2) ||
                        matchCore(s, sindex + 1, pattern, pindex ) ||
                        matchCore(s, sindex + 1, pattern, pindex + 2);
            } else {
                return matchCore(s, sindex, pattern, pindex + 2);
            }
        }
        if (sindex != s.length() && s.charAt(sindex) == pattern.charAt(pindex) || (pattern.charAt(pindex) == '.' && sindex < s.length())) {
            return matchCore(s, sindex + 1, pattern, pindex + 1);
        }
        return false;
    }
}
