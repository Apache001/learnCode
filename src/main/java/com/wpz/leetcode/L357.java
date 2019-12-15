package com.wpz.leetcode;

/**
 * @Author: wpz
 * @Desctription: 计算各个位数不同的数字个数
 * @Date: Created in 2019/12/12 20:54
 */
public class L357 {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int sum = 10;
        int tmp = 9;
        for (int i = 0; i < n - 1; i++) {
            tmp = tmp * (9 - i);
            sum += tmp;
        }
        return sum;
    }
}
