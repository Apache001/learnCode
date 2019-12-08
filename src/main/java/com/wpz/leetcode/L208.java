package com.wpz.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: wpz
 * @Desctription: 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * @Date: Created in 2019/12/8 20:18
 */
public class L208 {

    public static void main(String[] args) {

    }

    /**
     * 字典树节点
     */
    class TrieNode {
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

    TrieNode root = null;

    L208() {
        root = new TrieNode();
    }

    private void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            TrieNode node = current.next.get(c);
            if (node == null) {
                current.next.put(c, new TrieNode());
            }
            current = current.next.get(c);
        }
        if (!current.isWord) {
            current.isWord = true;
        }
    }

    private boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.next.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
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
