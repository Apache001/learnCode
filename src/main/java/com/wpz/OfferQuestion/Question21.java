package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 调整数组是奇数位于偶数前面
 * @Date: Created in 2019/12/10 22:50
 */
public class Question21 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        adjust(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void adjust(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int p = 0, q = arr.length - 1;

        while (p < q) {
            while (p < q && arr[p] % 2 != 0) {
                p++;
            }
            while (p < q && arr[q] % 2 == 0) {
                q--;
            }

            int tmp = arr[p];
            arr[p] = arr[q];
            arr[q] = tmp;
        }
    }
}

