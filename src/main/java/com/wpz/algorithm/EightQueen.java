package com.wpz.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/12/4 21:55
 */
public class EightQueen {
    public static void main(String[] args) {

        solution();
        System.out.println(res.size());

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 8; j++) {
                int c = res.get(i).get(j);
                for (int k = 0; k < 8; k++) {
                    if (k == c) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static List<Map<Integer, Integer>> res = new ArrayList<>();

    public static void solution() {

        //map: key位行，value为当前行可以放皇后的列
        backtrace(new HashMap<>(), 0);
    }

    private static void backtrace(Map<Integer, Integer> map, int row) {
        if (row == 8) {
            res.add(new HashMap<>(map));
        }

        for (int column = 0; column < 8; column++) {
            if (isOk(row, column, map)) {
                map.put(row, column);
                backtrace(map, row + 1);
                //回溯
                map.remove(row);
            }
        }

    }

    //是否有冲突
    private static boolean isOk(int row, int column, Map<Integer, Integer> map) {
        if (row == 0) {
            return true;
        }
        int leftUp = column - 1;
        int rightUp = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            if (map.get(i) == column) {
                return false;
            }

            if (leftUp >= 0 && map.get(i) == leftUp) {
                return false;
            }

            if (rightUp >= 0 && rightUp < 8 && map.get(i) == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }
}
