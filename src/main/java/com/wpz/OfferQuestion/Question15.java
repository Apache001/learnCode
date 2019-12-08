package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 二进制中1的个数
 * @Date: Created in 2019/12/8 14:41
 */
public class Question15 {

    public static void main(String[] args) {
        System.out.println(getCount(-5));
    }

    private static int getCount(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    private static int getCount2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            //把一个数最右边的1变为0
            n = (n - 1) & n;
        }
        return count;
    }
}
