package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author: wpz
 * @Desctription: 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * @Date: Created in 2019/12/8 18:59
 */
public class L212 {

    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board =
            {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
            };

        List<String> res = findWords(board, words);
        System.out.println(res);

    }


    static List<String> res = new ArrayList<>();

    private static List<String> findWords(char[][] board, String[] words) {
        //set 去重
        Set<String> set = new HashSet<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i]);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                dfs(board, row, column, "", trie, visited, words.length, set);
            }
        }
        res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    private static void dfs(char[][] board, int row, int column, String str, Trie trie, boolean[][] visited, int wordCount, Set<String> set) {
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
        if (!trie.containPrefix(str)) {
            return;
        }
        if (trie.containWord(str)) {
            set.add(str);
        }
        visited[row][column] = true;

        dfs(board, row, column + 1, str, trie, visited, wordCount, set);
        dfs(board, row, column - 1, str, trie, visited, wordCount, set);
        dfs(board, row + 1, column, str, trie, visited, wordCount, set);
        dfs(board, row - 1, column, str, trie, visited, wordCount, set);
        visited[row][column] = false;
    }


    static TrieNode root;

    static class TrieNode {

        boolean isWord;
        Map<Character, TrieNode> next;

        TrieNode(boolean isWord) {
            this();
            this.isWord = isWord;
        }

        TrieNode() {
            next = new TreeMap<>();
        }
    }

    static class Trie {

        Trie() {
            root = new TrieNode();
        }

        private void addWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                TrieNode tmp = current.next.get(c);
                if (tmp == null) {
                    current.next.put(c, new TrieNode());
                }
                current = current.next.get(c);
            }
            if (!current.isWord) {
                current.isWord = true;
            }
        }

        public boolean containWord(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                TrieNode next = current.next.get(c);
                if (next == null) {
                    return false;
                }
                current = next;
            }
            return current.isWord;
        }

        public boolean containPrefix(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                TrieNode next = current.next.get(c);
                if (next == null) {
                    return false;
                }
                current = next;
            }
            return true;
        }
    }


}
