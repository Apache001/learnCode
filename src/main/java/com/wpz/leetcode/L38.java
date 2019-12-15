package com.wpz.leetcode;

/**
 * @Author: wpz
 * @Desctription: 报数
 * @Date: Created in 2019/12/12 23:00
 */
public class L38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(50));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            String str = sb.toString();
            sb.delete(0, sb.length());
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    count = 1;
                }
            }
        }
        return sb.toString();
    }
}
