package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 是否有效的数独
 * @date 2019/12/5 16:30
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L36 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(i, j, board, board[i][j] - '0')) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValid(int row, int column, char[][] board, int num) {
        //排除自身
        for (int i = 0; i < 9; i++) {
            if (column != i && board[row][i] - '0' == num) {
                return false;
            }
        }
        //排除自身
        for (int i = 0; i < 9; i++) {
            if (row != i && board[i][column] - '0' == num) {
                return false;
            }
        }
        int tmpRow = row / 3;
        int tmpColumn = column / 3;

        //9*9小方格是否满足
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //排除自身
                if (row == (tmpRow * 3 + i) && column == (tmpColumn * 3 + j)) {
                    continue;
                }
                if (board[tmpRow * 3 + i][tmpColumn * 3 + j] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
