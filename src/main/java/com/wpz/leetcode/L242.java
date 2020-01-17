package com.wpz.leetcode;

import java.util.HashMap;
import java.util.ListResourceBundle;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.stream.events.EntityReference;

/**
 * 替换后的最长重复字符
 *
 * @author wangpengzhe
 * @date 2020/1/16 12:40
 */
public class L242 {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 1));
    }


    public static int characterReplacement(String s, int k) {
        if (k >= s.length() - 1) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>(16);

        int max = 0;
        //滑动窗口左指针
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            //记录串口中出现次数最多字符的个数
            max = Math.max(max, getMaxOfMap(map));

            //(right - left + 1 - max) > k 则左指针增加，缩小窗口
            while (left < right && (right - left + 1 - max) > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(right - left + 1, res);
        }

        return res;
    }

    private static int getMaxOfMap(Map<Character, Integer> map) {
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
