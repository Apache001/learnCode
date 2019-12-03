package com.wpz.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author wangpengzhe
 * @description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M
 * @date 2019/11/29 17:40
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L13 {

    public static void main(String[] args) {
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000

        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
