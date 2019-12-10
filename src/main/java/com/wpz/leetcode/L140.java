package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author wangpengzhe
 * @description 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * @date 2019/12/10 14:55
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L140 {

    public static void main(String[] args) {
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }

    static List<List<String>> lists = new ArrayList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (CollectionUtils.isEmpty(wordDict) || StringUtils.isEmpty(s)) {
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

    public static boolean isSplit(String s, List<String> dict) {
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

    private static void backtrace(String str, Map<String, Integer> map, List<String> list) {
        if (str == null || str.length() == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        String s;
        for (int i = 1; i <= str.length(); i++) {
            s = str.substring(0, i);
            if (map.get(s) != null) {
                list.add(s);
                backtrace(str.substring(i, str.length()), map, list);
                list.remove(list.size() - 1);
            }
        }
    }

}
