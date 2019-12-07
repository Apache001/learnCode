package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 二维数组每一行，每一列都是递增排列，输入一个数，判断数组中是否存在
 * @Date: Created in 2019/12/7 16:35
 */
public class Question4 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(isExist(nums, 5));
    }

    public static boolean isExist(int[][] nums, int val) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int row = 0;
        int column = nums[0].length - 1; //数组右上角坐标

        while (row < nums.length && column >= 0) {
            if (nums[row][column] == val) {
                return true;
            } else if (nums[row][column] < val) {
                //排除row这一行
                row++;
            } else {
                //排除column这一列
                column--;
            }
        }
        return false;
    }

}
