package com.wpz.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import javafx.scene.layout.Priority;

/**
 * 添加说明记得一定要大于十个字符
 *
 * @author wangpengzhe
 * @date 2020/2/11 10:51
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.print(queue.offer(1) + " ");
        System.out.print(queue.offer(2) + " ");
        System.out.print(queue.offer(3) + " ");
        System.out.print(queue.take() + " ");
        System.out.println(queue.size());

//        int[][] arr = {{1, 0}};
//        int[] res = findOrder(2, arr);
//
//        for (int i : res) {
//            System.out.print(i + " ");
//        }

//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {4,5,6};
//        merge(nums1,3,nums2,3);

//        List<String> list = new ArrayList<>();
//        list.add("ale");
//        list.add("apple");
//        list.add("monkey");
//        list.add("plea");
//        String res = findLongestWord("abpcplea", list);
//        System.out.println(res);

        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] list = new ArrayList[s.length() + 1];

        for (char c : map.keySet()) {
            int count = map.get(c);
            if (list[count] == null) {
                list[count] = new ArrayList();
            }
            list[count].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            List<Character> t = list[i];
            if (t == null || t.size() == 0) {
                continue;
            }
            for (char c : t) {
                for (int n = 0; n < i; n++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String t : d) {
            int l = 0;
            int h = 0;
            if (t.length() > s.length()) {
                continue;
            } else {
                while (l < t.length() && h < s.length()) {
                    if (t.charAt(l) == s.charAt(h)) {
                        l++;
                        h++;
                    } else {
                        h++;
                    }
                }
                if (l == t.length()) {
                    if (t.length() > res.length()) {
                        res = t;
                    } else if (t.length() < res.length()) {
                        continue;
                    } else {
                        res = res.compareToIgnoreCase(t) < 0 ? res : t;
                    }
                }
            }
        }
        return res;

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        int[] res = new int[m + n];
        int index = 0;
        for (int k = 0; k < m + n; k++) {
            if (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    res[index++] = nums1[i];
                    i++;
                } else {
                    res[index++] = nums2[j];
                    j++;
                }
            } else {
                if (j < n) {
                    while (j < n) {
                        res[index++] = nums2[j];
                        j++;
                    }
                } else {
                    while (i < m) {
                        res[index++] = nums1[i];
                        i++;
                    }
                }
            }

            for (int p = 0; p < m + n; p++) {
                nums1[p] = res[p];
            }
        }


    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //拓扑排序
        List<Integer>[] graph = new List[numCourses];
        //入度数组
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            result[index++] = poll;
            List<Integer> next = graph[poll];
            for (int k : next) {
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }

}
