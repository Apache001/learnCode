package com.wpz.leetcode;

import jdk.nashorn.internal.ir.CatchNode;

/**
 * @author wangpengzhe
 * @description 反转数值  123->321l
 * @date 2019/11/27 9:51
 */
public class L7 {


    public static void main(String[] args) {
        System.out.println(reverse(-123456));

    }

    private static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //判断是否正溢出
            int pop = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            //判断是否负溢出
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = (pop + res * 10);
            x /= 10;
        }

        return res;
    }


}
