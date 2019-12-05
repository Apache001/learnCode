package com.wpz.leetcode;

import java.util.Arrays;

/**
 * @author wangpengzhe
 * @description 解数独
 * @date 2019/12/5 12:46
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L37 {

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

        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }

    }

    static char[][] res = new char[9][9];

    public static void solveSudoku(char[][] board) {
        backtrace(0, 0, board);
    }

    private static void backtrace(int row, int column, char[][] board) {
        if (row == 8 && column == 9) {
            copyArray(board, res);
            return;
        }
        if (column == 9) {
            row++;
            column = 0;
        }
        if (board[row][column] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (isValid(row, column, board, i)) {
                    board[row][column] = (char) (i + '0');
                    backtrace(row, column + 1, board);
                    //不满足条件回溯
                    board[row][column] = '.';
                }
            }

        } else {
            backtrace(row, column + 1, board);
        }

    }

    private static void copyArray(char[][] source, char[][] target) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                target[i][j] = source[i][j];
            }
        }
    }


    private static boolean isValid(int row, int column, char[][] board, int num) {
        //行列是否满足
        for (int i = 0; i < 9; i++) {
            if (board[row][i] - '0' == num || board[i][column] - '0' == num) {
                return false;
            }
        }

        int tmpRow = row / 3;
        int tmpColumn = column / 3;

        //9*9小方格是否满足
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[tmpRow * 3 + i][tmpColumn * 3 + j] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
