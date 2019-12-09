package com.wpz.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: wpz
 * @Desctription:  search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * @Date: Created in 2019/12/8 20:43
 */
public class L211 {
    public static void main(String[] args) {
        L211 root = new L211();
//        root.addWord("bad");
//        root.addWord("dad");
//        root.addWord("addword");
//        root.addWord("mad");
        //   System.out.println(root.search("pad"));
        //   System.out.println(root.search("bad"));
        //   System.out.println(root.search(".ad"));
        //  System.out.println(root.search("a.d"));

//        String[] str = {"at", "an", "and", "add", "bat"};
//        for (String s : str) {
//            root.addWord(s);
//        }

//        String[] search = {"a", ".at", ".at", "an.", "a.d.", "b.", "a.d", "."};
//        for (String ss : search) {
//            System.out.print(root.search(ss) + " ");
//        }

        //System.out.println(root.search("a.d"));
        root.addWord("a");
        System.out.println(root.search("a."));

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

    L211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode current = root;

        return searchRec(word.toCharArray(), 0, word.length(), current, 0);
    }

    private boolean searchRec(char[] chars, int start, int length, TrieNode root, int count) {
        if (start == length && root.isWord && count >= length) {
            return true;
        }
        if (start == length) {
            return false;
        }

        for (int i = start; i < length; i++) {
            if (chars[i] == '.') {
                Map<Character, TrieNode> next = root.next;
                if (next == null || next.size() == 0 && length <= count) {
                    return true;
                }
                if (next == null || next.size() == 0) {
                    return false;
                }
                count++;
                for (Map.Entry<Character, TrieNode> entry : next.entrySet()) {
                    if (searchRec(chars, i + 1, length, entry.getValue(), count)) {
                        return true;
                    }
                }
                return false;
            } else {
                TrieNode node = root.next.get(chars[i]);
                if (node == null) {
                    return false;
                }
                count++;
                root = node;
            }
        }
        return root.isWord && count >= length;
    }
}
