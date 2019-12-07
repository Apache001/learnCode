package com.wpz.leetcode;

/**
 * @Author: wpz
 * @Desctription: 第K个排列
 * @Date: Created in 2019/12/6 20:34
 */
public class L60 {
    public static void main(String[] args) {
        System.out.println(getPermutation(9, 353955));
    }

    static int count = 0;

    public static String getPermutation(int n, int k) {
        backtrace(0, n, k, new StringBuilder());
        return r;
    }

    //static List<Integer> res = new ArrayList<>();
    static String r = "";

    private static void backtrace(int start, int n, int k, StringBuilder sb) {
        if (sb.length() == n) {
            count++;
            if (count == k) {
                r = new String(sb);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (sb.indexOf(String.valueOf(i)) == -1) {
                sb.append(i);
                backtrace(i + 1, n, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
