package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @date 2019/11/29 10:39
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L50 {

    public static void main(String[] args) {
        System.out.println(myPow(3, 2));
    }


    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
}
