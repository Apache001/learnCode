package com.wpz.leetcode;

/**
 * @Author: wpz
 * @Desctription: 单词搜索
 * @Date: Created in 2019/12/8 17:40
 */
public class L79 {
    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        char[][] b = {{'A','B'}};
        System.out.println(exist(b, "BA"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        int curLength = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isValid(board, i, j, word, curLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(char[][] board, int row, int column, String word, int curLength, boolean[][] visited) {
        if (curLength == word.length()) {
            return true;
        }
        boolean flag = false;
        if (row >= 0 && row < board.length && column >= 0 && column < board[row].length && !visited[row][column] && board[row][column] == word.charAt(curLength)) {
            curLength++;
            visited[row][column] = true;
            flag = isValid(board, row, column + 1, word, curLength, visited) ||
                    isValid(board, row, column - 1, word, curLength, visited) ||
                    isValid(board, row + 1, column, word, curLength, visited) ||
                    isValid(board, row - 1, column, word, curLength, visited);
            if (!flag) {
                visited[row][column] = false;
            }
        }
        return flag;
    }
}
