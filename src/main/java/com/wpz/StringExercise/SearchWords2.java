package com.wpz.StringExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        String[] words = {"ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb"};
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dfs(board, words.length, i, j, visited, "");
            }
        }

        return res;
    }

    private void dfs(char[][] board, int wordCount, int row, int column, boolean[][] visited, String str) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length) {
            return;
        }
        if (res.size() == wordCount) {
            return;
        }
        if (visited[row][column]) {
            return;
        }

        str += board[row][column];
        if (!searchWordPrefix(str)) {
            return;
        }
        if (searchWord(str)) {
            if (!res.contains(str)) {
                res.add(str);
            }
        }
        visited[row][column] = true;
        dfs(board, wordCount, row, column + 1, visited, str);
        dfs(board, wordCount, row, column - 1, visited, str);
        dfs(board, wordCount, row + 1, column, visited, str);
        dfs(board, wordCount, row - 1, column, visited, str);
        visited[row][column] = false;
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
        if (word == null || word.length() == 0) {
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
