package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @date 2019/11/29 14:44
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        int l = 0;
        int r = x;
        while ((r - l) > 1) {
            int middle = l + (r - l) / 2;
            if (x / middle < middle) {
                r = middle;
            } else {
                l = middle;
            }
        }
        return l;
    }
}
