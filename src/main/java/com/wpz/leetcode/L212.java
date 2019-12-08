package com.wpz.leetcode;

import java.util.List;

/**
 * @Author: wpz
 * @Desctription: 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
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

    //TODO
    public static List<String> findWords(char[][] board, String[] words) {
        return null;
    }
}
