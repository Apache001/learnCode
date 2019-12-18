package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * @date 2019/12/18 14:05
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L29 {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int num = 0;
        long sum;
        while (b <= a) {
            sum = b;
            int count = 1;
            while (sum + sum <= a) {
                count += count;
                sum += sum;
            }
            a = a - sum;
            num = num + count;
        }
        if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) {
            num = -num;
        }
        return num;
    }

}
