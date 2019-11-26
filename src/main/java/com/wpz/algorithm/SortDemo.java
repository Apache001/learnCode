package com.wpz.algorithm;


/**
 * @author wangpengzhe
 * @description
 * @date 2019/11/25 9:38
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 8, 10, 7, 9, 28, 4};

        System.out.println(findK(arr, 8));
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 冒泡排序
     *
     * @return void
     */
    private static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @return void
     */
    private static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (val < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
        }
    }

    /**
     * 选择排序
     *
     * @return void
     */
    private static void selectSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }

    /**
     * 归并排序
     *
     * @return void
     */
    private static void mergeSort(int[] arr) {
        mergeSort_A(arr, 0, arr.length - 1);
    }

    private static void mergeSort_A(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort_A(arr, left, mid);
        mergeSort_A(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int p1 = left, p2 = mid + 1, k = left;

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2]) {
                tmp[k++] = a[p1++];
            } else {
                tmp[k++] = a[p2++];
            }
        }

        while (p1 <= mid) {
            tmp[k++] = a[p1++];
        }//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) {
            tmp[k++] = a[p2++];
        }//同上

        //复制回原素组
        for (int i = left; i <= right; i++) {
            a[i] = tmp[i];
        }
    }

    /**
     * 快速排序
     *
     * @return void
     */
    private static void quickSort(int[] arr) {
        quickSort_A(arr, 0, arr.length - 1);
    }

    private static void quickSort_A(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);
        quickSort_A(arr, left, pivot - 1);
        quickSort_A(arr, pivot + 1, right);
    }


    /**
     * O(n)时间复杂度求数组地k大元素
     *
     * @return int
     */
    private static int findK(int[] arr, int k) {
        if (k >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("超出数组最大长度");
        }
        return findK_A(arr, k, 0, arr.length - 1);
    }

    private static int findK_A(int[] arr, int k, int left, int right) {
        int pivot = partition(arr, left, right);
        if (k == pivot + 1) {
            return arr[pivot];
        } else if (k > pivot + 1) {
            return findK_A(arr, k, pivot + 1, right);
        } else {
            return findK_A(arr, k, left, pivot - 1);
        }
    }


    private static int partition(int[] arr, int l, int r) {
        int p = l, q = r;
        int pivotValue = arr[r];
        while (p < q) {
            while (p < q && arr[p] <= pivotValue) {
                p++;
            }
            while (p < q && arr[q] >= pivotValue) {
                q--;
            }
            if (p < q) {
                swap(arr, p, q);
            }
        }
        swap(arr, p, r);
        return p;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
