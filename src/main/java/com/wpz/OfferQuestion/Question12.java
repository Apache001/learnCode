package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 矩阵中的路径
 * @Date: Created in 2019/12/8 10:44
 */
public class Question12 {
    public static void main(String[] args) {
        char[][] nums = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'},
        };

        System.out.println(isExist(nums, "abfe"));
    }


    private static boolean isExist(char[][] nums, String str) {
        boolean[][] visited = new boolean[nums.length][nums[0].length];
        int curCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (hasPath(nums, i, j, str, visited, curCount)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPath(char[][] nums, int row, int column, String str, boolean[][] visited, int curCount) {
        if (curCount == str.length()) {
            return true;
        }

        boolean flag = false;
        if (row >= 0 && row < nums.length && column >= 0 && column < nums[0].length && !visited[row][column] && str.charAt(curCount) == nums[row][column]) {
            curCount++;
            visited[row][column] = true;
            flag = hasPath(nums, row, column + 1, str, visited, curCount) ||
                    hasPath(nums, row, column - 1, str, visited, curCount) ||
                    hasPath(nums, row + 1, column, str, visited, curCount) ||
                    hasPath(nums, row - 1, column, str, visited, curCount);
            if (!flag) {
                visited[row][column] = false;
            }
        }
        return flag;
    }

}
