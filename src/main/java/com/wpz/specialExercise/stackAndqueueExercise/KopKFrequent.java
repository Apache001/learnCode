package com.wpz.specialExercise.stackAndqueueExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 前 K 个高频元素 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 *
 * @author wangpengzhe
 * @date 2020/1/9 13:30
 */
public class KopKFrequent {

    public static void main(String[] args) {

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        return new ArrayList<>(priorityQueue);
    }
}
