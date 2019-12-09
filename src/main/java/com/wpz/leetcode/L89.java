package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * @date 2019/12/9 17:49
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L89 {

    public static void main(String[] args) {
        System.out.println(grayCode(4));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i) {
            list.add(i ^ i >> 1);
        }
        return list;
    }

}
