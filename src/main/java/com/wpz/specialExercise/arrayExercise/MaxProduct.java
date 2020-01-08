package com.wpz.specialExercise.arrayExercise;

/**
 * 乘积最大子序列
 *
 * @author wangpengzhe
 * @date 2019/12/30 19:31
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {2, -5, -2, -4, 3};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);

            if (max > res) {
                res = max;
            }
        }

        return res;
    }
}
