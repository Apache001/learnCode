package com.wpz.algorithm;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
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
//        BlockingQueue<Integer> queue = new SynchronousQueue<>();
//        System.out.print(queue.offer(1) + " ");
//        System.out.print(queue.offer(2) + " ");
//        System.out.print(queue.offer(3) + " ");
//        System.out.print(queue.take() + " ");
//        System.out.println(queue.size());

//
        List<List<Integer>> res = new ArrayList<>();
        Iterator it = res.iterator();
        // it.remove();
        Iterator it2 = res.iterator();
        System.out.println(it == it2);
//        res.containsAll()
//        System.out.println(multiply("121323434313131223", "455424324343243423426"));
//        System.out.println(reverseWords("ds "));
        //   System.out.println(simplifyPath("/home/pig"));
        System.out.println(getPermutation(4, 14));

    }


    public static int[][] merge(int[][] intervals) {
        //边界判断
        if (intervals.length <= 1) {
            return intervals;
        }

        //先按起点位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        //利用list存储合并好的区间
        List<int[]> result = new ArrayList<>();
        //初始时将第一个区间放入list中
        result.add(intervals[0]);
        //记录上一合并好的区间在list中的位置
        int last = 0;
        //遍历并合并后面各区间
        for (int i = 1; i < intervals.length; i++) {
            //上一合并好的区间的起点和终点
            int lastStart = result.get(last)[0];
            int lastEnd = result.get(last)[1];
            //当前要合并的区间的起点和终点
            int start = intervals[i][0];
            int end = intervals[i][1];
            //如果左边重合
            if (lastStart == start) {
                if (end > lastEnd) {
                    result.set(last, new int[]{start, end});
                }
            } else {    //如果左边不重合
                if (start > lastEnd) {
                    result.add(new int[]{start, end});
                    last++;
                } else {
                    if (end > lastEnd) {
                        result.set(last, new int[]{lastStart, end});
                    }
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    public static String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        n--;
        StringBuilder res = new StringBuilder();
        while (n >= 0) {
            int t = factorial[n];
            int loc = (int) (Math.ceil((double) k / (double) t)) - 1;
            if (loc == -1) {
                loc = num.size() - 1;
            }
            res.append(num.get(loc));
            num.remove(loc);
            k %= t;
            n--;
        }
        return res.toString();
    }

    public static String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();

        stack.push("/");
        for (String s : str) {
            if (s.equals(".") || s.isEmpty()) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        List<String> list = new ArrayList<>();
        list.add("/");
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            if (!tmp.equals("/")) {
                list.add(tmp);
                list.add("/");
            }
        }
        String res = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            res += list.get(i);
        }
        if (res.equals("/")) {
            return res;
        }
        return res.substring(0, res.length() - 1);
    }

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();

        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                tmp += s.charAt(i);
            } else if (!tmp.isEmpty()) {
                stack.push(tmp);
                tmp = "";
            }
        }

        if (!tmp.isEmpty()) {
            stack.push(tmp);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop() + " ";
        }

        return res.substring(0, res.length() - 1);
    }

    public static String multiply(String num1, String num2) {

        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            arr1[i] = Integer.parseInt(String.valueOf(num1.charAt(i)));
        }
        for (int j = 0; j < num2.length(); j++) {
            arr2[j] = Integer.parseInt(String.valueOf(num2.charAt(j)));
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                result[i + j] += arr1[i] * arr2[j];
            }
        }

        int jinwei = 0;
        for (int i = result.length - 1; i > 0; i--) {
            jinwei = result[i] / 10;
            result[i - 1] += jinwei;
            result[i] = result[i] % 10;
        }

        String resultstr = "";
        for (int i = 0; i < result.length - 1; i++) {
            resultstr += "" + result[i];
        }

        return resultstr;

    }

    public static void getResult(int[] nums, int n) {

        backtrace(nums, new ArrayList<>(), n);
    }

    static List<List<Integer>> res = new ArrayList<>();

    private static void backtrace(int[] nums, List<Integer> list, int n) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrace(nums, list, n);
                list.remove(list.size() - 1);
            }
        }
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
