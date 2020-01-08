package com.wpz.specialExercise.StringExercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wpz
 * @Desctription: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * @Date: Created in 2019/12/24 21:15
 */
public class SplitWord {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "pen");
        System.out.println(wordBreak("applepenapple", list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : wordDict) {
            map.put(word, 1);
        }
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && map.get(s.substring(j, i)) != null) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
