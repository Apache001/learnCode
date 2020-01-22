package leetcode.hot100;

import java.beans.BeanInfo;
import java.util.Stack;

/**
 * leetcode - 04 寻找两个有序数组的中位数  https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author wangpengzhe
 * @date 2020/1/22 15:00
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {

    }

    /**
     * 寻找两个有序数组组中位数<=>寻找两个数组第K小的数 k=(m+n)/2
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int leftK = (m + n + 1) / 2;
        int rightK = (m + n + 2) / 2;

        return (getK(nums1, 0, n - 1, nums2, 0, m - 1, leftK) + getK(nums1, 0, n - 1, nums2, 0, m - 1, rightK)) / 2.0;
    }

    private static int getK(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2){
            return getK(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getK(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getK(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
