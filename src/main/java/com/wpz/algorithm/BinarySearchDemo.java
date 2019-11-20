package com.wpz.algorithm;


import java.lang.annotation.Target;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/11/20 14:26
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 6, 8, 12, 16};

        System.out.println(bSearchLast(arr, 4));
        System.out.println(sqrt(9, 5));

    }

    /**
     * 二分查找
     *
     * @return int
     */
    public static int bSearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == val) {
                return middle;
            }
            if (arr[middle] < val) {
                low = middle + 1;
            }
            if (arr[middle] > val) {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找(递归)
     *
     * @return int
     */
    private static int bSearchRecurse(int[] arr, int val) {
        return recurse(arr, 0, arr.length - 1, val);
    }

    private static int recurse(int[] arr, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (arr[middle] == val) {
            return middle;
        } else if (arr[middle] < val) {
            return recurse(arr, middle + 1, high, val);
        } else {
            return recurse(arr, low, middle - 1, val);
        }
    }

    /**
     * 查找第一个等于给定值的元素
     *
     * @return int
     */
    private static int bSearchFirst(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == val && arr[middle - 1] != val) {
                return middle;
            } else if (arr[middle] >= val) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的元素
     *
     * @return int
     */
    private static int bSearchLast(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == val && arr[middle + 1] != val) {
                return middle;
            } else if (arr[middle] > val) {
                high = middle - 1;
            } else if (arr[middle] <= val) {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @return int
     */
    private static int bSearchFirstGTE(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] >= val) {
                if ((middle == 0) || (arr[middle - 1] < val)) {
                    return middle;
                }
                high = middle - 1;
            } else {
                low = low + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法求一个数的平方根
     *
     * @return double
     */
    private static double sqrt(double t, int n) {
        double low = 0D;
        double high = t;
        double middle = low + (high - low) / 2;
        while (Math.abs((middle * middle - t)) > Math.pow(10, -n)) {
            if (middle * middle == t) {
                return middle;
            }
            if (middle * middle > t) {
                high = middle;
            } else {
                low = middle;
            }
            middle = low + (high - low) / 2;
        }
        return middle;
    }

    /**
     * 循环数组查找
     *
     * @return int
     */
    private static int find(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == val) {
                return middle;
            }
            //转折点在middle右边
            if (arr[middle] >= arr[low]) {
                if (arr[low] < val && arr[middle] > val) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else {
                if (arr[middle] < val && val <= arr[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }

        }
        return -1;
    }

}
