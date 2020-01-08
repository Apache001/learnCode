package com.wpz.specialExercise.stackAndqueueExercise;


/**
 * 数组中的第K个最大元素
 *
 * @author wangpengzhe
 * @date 2020/1/7 17:59
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 7, 3, 4, 6};
        System.out.println(findKthLargest2(nums, 4));

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            throw new IllegalArgumentException();
        }
        return findK(nums, k, 0, nums.length - 1);
    }

    private static int findK(int[] nums, int k, int left, int right) {
        int pivot = partition(nums, left, right);
        if (k == pivot + 1) {
            return nums[pivot];
        } else if (k > pivot + 1) {
            return findK(nums, k, pivot + 1, right);
        } else {
            return findK(nums, k, left, pivot - 1);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] <= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] >= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    /**********************************使用大顶堆方法************************************************/

    public static int findKthLargest2(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            throw new IllegalArgumentException();
        }

        initHeap(nums, nums.length);

        int index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            index++;
            if (index == k) {
                break;
            }
            adjust(nums, 0, i - 1);
        }
        return nums[nums.length - index];
    }

    public static void initHeap(int[] nums, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, length);
        }
    }

    private static void adjust(int[] nums, int i, int length) {
        //左孩子节点下标
        int left = 2 * i + 1;
        //右孩子节点下标
        int right = 2 * i + 2;

        int max = i;
        if (left < length && nums[left] > nums[i]) {
            max = left;
        }
        if (right < length && nums[right] > nums[max]) {
            max = right;
        }
        //获取左孩子、右孩子、根节点最大值，如果最大值等于当前值不用交换，否则将最大值和当前节点数据交换，递归调整下面节点
        if (max != i) {
            swap(nums, i, max);
        } else {
            return;
        }

        adjust(nums, max, length);
    }

    private static void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}
