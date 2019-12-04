package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/12/4 17:41
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L849 {

    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);
            }
        }

        int pre = list.get(0);
        int max = Math.max(list.get(0), seats.length - 1 - list.get(list.size() - 1));
        for (int j = 0; j < list.size(); j++) {
            max = Math.max(max, (list.get(j) - pre) / 2);
            pre = list.get(j);
        }
        return max;
    }
}
