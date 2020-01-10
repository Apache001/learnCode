package com.wpz.specialExercise.stackAndqueueExercise;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 返回滑动窗口中的最大值。
 *
 * @author wangpengzhe
 * @date 2020/1/9 13:58
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[0];
        int n = 0;
        if (nums == null || nums.length < 1 || k <= 0 || k > nums.length) {
            return res;
        } else {
            res = new int[nums.length - k + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
            if (i >= k - 1) {
                res[n++] = nums[queue.peek()];
            }
        }

        return res;
    }

}
