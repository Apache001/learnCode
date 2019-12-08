package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 旋转数组的最小数字
 * @Date: Created in 2019/12/8 10:11
 */
public class Question11 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }


    private static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] == nums[high]) {
                high = mid - 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
