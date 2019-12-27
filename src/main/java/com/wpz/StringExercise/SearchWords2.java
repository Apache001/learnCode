package com.wpz.StringExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索2
 *
 * @author wangpengzhe
 * @date 2019/12/27 12:46
 */
public class SearchWords2 {

    public static void main(String[] args) {
//        String[] words = {"oath", "pea", "eat", "rain", "erv","oe"};
//        char[][] board = {
//            {'o', 'a', 'a', 'n'},
//            {'e', 't', 'a', 'e'},
//            {'i', 'h', 'k', 'r'},
//            {'i', 'f', 'l', 'v'}
//        };
        SearchWords2 trie = new SearchWords2();

        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        char[][] board = {{'a','b'},{'c','d'}};
        trie.findWords(board, words);

        System.out.println(trie.res);
    }


    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || board == null) {
            return res;
        }

        for (String word : words) {
            addWord(word);
        }

        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];

        for (String word : words) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (isValid(board, word, i, j, 0, visited, "")) {
                        if(!res.contains(word)){
                            res.add(word);
                        }
                    }
                }
            }
        }

        return res;
    }

    private boolean isValid(char[][] board, String word, int row, int column, int wordIndex, boolean[][] visited, String str) {
        if (word.length() == wordIndex) {
            return true;
        }

        boolean flag = false;
        if (row >= 0 && row < board.length && column >= 0 && column < board[0].length && board[row][column] == word.charAt(wordIndex)
            && !visited[row][column]) {
            wordIndex++;
            visited[row][column] = true;
            str += board[row][column];
            if (searchWord(str)) {
                return true;
            } else if (!searchWordPrefix(str)) {
                return false;
            }

            flag = isValid(board, word, row, column + 1, wordIndex, visited, str) ||
                isValid(board, word, row, column - 1, wordIndex, visited, str) ||
                isValid(board, word, row + 1, column, wordIndex, visited, str) ||
                isValid(board, word, row - 1, column, wordIndex, visited, str);
            visited[row][column] = false;
        }
        return flag;
    }


    class Node {

        boolean isWord;
        Node[] next;

        Node() {
            this.next = new Node[26];
        }
    }

    Node root = null;

    SearchWords2() {
        root = new Node();
    }

    private void addWord(String word) {
        if (word == null) {
            return;
        }
        Node curr = root;
        for (char c : word.toCharArray()) {
            Node node = curr.next[c - 'a'];
            if (node == null) {
                curr.next[c - 'a'] = new Node();
            }
            curr = curr.next[c - 'a'];
        }

        curr.isWord = true;
    }

    private boolean searchWord(String word) {
        if (word == null) {
            return false;
        }

        Node curr = root;
        for (char c : word.toCharArray()) {
            Node node = curr.next[c - 'a'];
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return curr.isWord;
    }

    private boolean searchWordPrefix(String prefix) {
        if (prefix == null) {
            return false;
        }

        Node curr = root;
        for (char c : prefix.toCharArray()) {
            Node node = curr.next[c - 'a'];
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return true;
    }
}
