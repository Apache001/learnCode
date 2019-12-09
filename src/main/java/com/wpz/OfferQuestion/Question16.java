package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: x的n次方
 * @Date: Created in 2019/12/9 21:19
 */
public class Question16 {
    public static void main(String[] args) {
        System.out.println(pow(2,7));
    }

    private static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }
    }
}
