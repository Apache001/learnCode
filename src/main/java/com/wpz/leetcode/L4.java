package com.wpz.leetcode;

/**
 * 添加说明记得一定要大于十个字符
 *
 * @author wangpengzhe
 * @date 2020/1/19 19:52
 */
public class L4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 保证num1的长度总是小于或等于nums2
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int lengthTemp = m;
            m = n;
            n = lengthTemp;
        }
        int imax = m, imin = 0, half = (m + n + 1) / 2;
        //开始查找
        while (imax >= imin) {
            int i = (imax + imin) / 2;
            int j = half - i;
            // i 过小且i可以再增大
            if (i < imax && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            // i 过大且i可以再减小
            else if (i > imin && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int leftmax = 0;
                // left_num1为空时
                if (i == 0) {
                    leftmax = nums2[j - 1];
                }
                // left_num2为空时
                else if (j == 0) {
                    leftmax = nums1[i - 1];
                } else {
                    leftmax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                // 当m+n 为奇数时,返回奇数解
                if ((m + n) % 2 == 1) {
                    return leftmax;
                }

                int rightmin = 0;
                // right_num1为空时
                if (i == m) {
                    rightmin = nums2[j];
                }
                // right_num2为空时
                else if (j == n) {
                    rightmin = nums1[i];
                } else {
                    rightmin = Math.min(nums1[i], nums2[j]);
                }
                // 当m+n 为偶数时,返回偶数解
                return (leftmax + rightmin) / 2.0;
            }
        }
        return 0;
    }
}
