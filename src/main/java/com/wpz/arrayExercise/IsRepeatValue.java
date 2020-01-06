package com.wpz.arrayExercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * @author wangpengzhe
 * @date 2020/1/6 13:53
 */
public class IsRepeatValue {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                int t = map.get(nums[i]);
                map.put(nums[i], ++t);
            }
        }
        for (int i : nums) {
            if (map.get(i) > 1) {
                return true;
            }
        }
        return false;
    }
}
