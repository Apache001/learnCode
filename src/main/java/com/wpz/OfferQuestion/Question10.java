package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 斐波那契数列第n项
 * @Date: Created in 2019/12/7 22:41
 */
public class Question10 {
    public static void main(String[] args) {
        System.out.println(fibnacciRec(10));
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int fibnacciRec(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        return fibnacciRec(n - 1) + fibnacciRec(n - 2);
    }

    /**
     * 迭代法
     *
     * @param n
     * @return
     */
    private static int fibnacciDie(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += a;
            a = b;
            b = res;
        }
        return res;
    }

}
