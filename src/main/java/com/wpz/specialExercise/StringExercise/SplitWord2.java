package com.wpz.specialExercise.StringExercise;

import java.util.*;

/**
 * @Author: wpz
 * @Desctription: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * @Date: Created in 2019/12/24 22:04
 */
public class SplitWord2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak("catsanddog", list));

    }

    static List<List<String>> lists = new ArrayList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), 1);
        }
        if (!isSplit(s, wordDict)) {
            return res;
        }

        backtrace(s, map, new ArrayList<>());
        for (int i = 0; i < lists.size(); i++) {
            String str = "";
            for (int j = 0; j < lists.get(i).size(); j++) {
                str += lists.get(i).get(j) + " ";
            }
            res.add(str.substring(0, str.length() - 1));
        }
        return res;
    }

    private static void backtrace(String s, Map<String, Integer> map, List<String> list) {
        if (s.length() == 0) {
            lists.add(new ArrayList<>(list));
        }

        String tmp;
        for (int i = 1; i <= s.length(); i++) {
            tmp = s.substring(0, i);
            if (map.get(tmp) != null) {
                list.add(tmp);
                backtrace(s.substring(i, s.length()), map, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isSplit(String s, List<String> dict) {
        int len = s.length();
        boolean[] now = new boolean[len + 1];
        now[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j, i);
                if (now[j] && dict.contains(tmp)) {
                    now[i] = true;
                    break;
                }

            }
        }
        return now[len];
    }
}
