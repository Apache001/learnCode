package com.wpz.arrayExercise;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author wangpengzhe
 * @date 2020/1/6 12:54
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }

        return res;
    }
}
