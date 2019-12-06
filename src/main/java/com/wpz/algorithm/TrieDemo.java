package com.wpz.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wangpengzhe
 * @description Trie树
 * @date 2019/12/6 13:28
 */
public class TrieDemo {

    public static void main(String[] args) {
        TrieDemo trieDemo = new TrieDemo();
        trieDemo.addWord("lisi");
        trieDemo.addWord("zhangsan");
        trieDemo.addWord("wangwu");

        System.out.println(trieDemo.size);
        System.out.println(trieDemo.containPrefix("wang"));
    }

    int size = 0;

    class Node {

        boolean isWord;
        Map<Character, Node> next;

        Node() {
            next = new TreeMap<>();
        }

        Node(boolean isWord) {
            this();
            this.isWord = isWord;
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    Node root = null;

    public TrieDemo() {
        root = new Node();
    }


    /**
     * 添加单词
     *
     * @return void
     */
    public void addWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            Node next = current.next.get(c);
            if (next == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        if (!current.isWord) {
            size++;
            current.isWord = true;
        }
    }

    /**
     * 查找完整单词
     *
     * @return boolean
     */
    public boolean containWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            Node next = current.next.get(c);
            if (next == null) {
                return false;
            }
            current = next;
        }
        return current.isWord;
    }

    /**
     * 是否包含指定前缀
     *
     * @return boolean
     */
    public boolean containPrefix(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            Node next = current.next.get(c);
            if (next == null) {
                return false;
            }
            current = next;
        }
        return true;
    }




    /**
     * 删除指定单词
     *
     * @return void
     */
    public void delWord(String word) {

    }
}
