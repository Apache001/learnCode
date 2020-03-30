package com.wpz.algorithm;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import javafx.scene.layout.Priority;
import sun.swing.BakedArrayList;

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
//        res.containsAll()
//        System.out.println(multiply("121323434313131223", "455424324343243423426"));
//        System.out.println(reverseWords("ds "));
        //   System.out.println(simplifyPath("/home/pig"));
        //  System.out.println(getPermutation(4, 14));
        //   System.out.println(lengthOfLongestSubstring2("abcabcbb"));
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(Arrays.asList(1,2,3));
//        System.out.println(longestPalindrome("abdafababa"));
        //  System.out.println(letterCombinations("23"));
//        System.out.println(Arrays.asList("leetcode".split("leetcode")));
//        int[][] grid = {
//            {1, 3, 1},
//            {1, 5, 1},
//            {4, 2, 1}
//        };

        //     List<List<Integer>> allPath = getAllPath(grid);

//        System.out.println(allPath);
//        System.out.println(allPath.size());


        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static char find(char[] chars1, char[] chars2) {
        int len = chars1.length > chars2.length ? chars1.length : chars2.length;
        boolean flag = chars1.length > chars2.length;
        for (int i = 0; i < len; i++) {
            if (chars1[i] != chars2[i]) {
                if (flag) {
                    return chars1[i];
                } else {
                    return chars2[i];
                }
            }
        }
        return ' ';
    }

    private static Integer[] getJ2(Integer[] array1, Integer[] array2) {
        if (array1 == null || array2 == null) {
            return null;
        }
        int n = array1.length > array2.length ? array2.length : array1.length;
        if (array1[0] > array2[array2.length - 1] || array2[0] > array1[array1.length - 1]) {
            return null;
        }
        Integer[] res = new Integer[n];
        int k = 0;
        int indexa = 0;
        int indexb = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (Objects.equals(array1[i], array2[j])) {
                    indexa = i;
                    indexb = j;
                    break;
                }
            }
        }
        while (Objects.equals(array1[indexa], array2[indexb])) {
            res[k++] = array1[indexa];
            indexa++;
            indexb++;
        }
        return res;

    }

    private static Integer[] getJ(Integer[] array1, Integer[] array2) {
        List<Integer> rs = new ArrayList<>();
        // 将较长的数组转换为set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(array1.length > array2.length ? array1 : array2));

        // 遍历较短的数组
        for (Integer i : array1.length > array2.length ? array2 : array1) {
            if (set.contains(i)) {
                rs.add(i);
            }
        }
        Integer[] arr = {};
        return rs.toArray(arr);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        for (String str : wordDict) {
            if (!sb.toString().contains(str)) {
                return false;
            }
            String[] split = sb.toString().split(str);
            sb = new StringBuilder();
            for (String tmp : split) {
                if (!sb.toString().contains(tmp)) {
                    sb.append(tmp);
                }
            }
        }
        return sb.length() == 0;
    }

    public static List<List<Integer>> getAllPath(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();

        backtrace(grid, 0, 0, new ArrayList<>(), res);

        return res;
    }

    private static void backtrace(int[][] grid, int r, int c, List<Integer> list, List<List<Integer>> res) {
        if (r >= grid.length || c >= grid[0].length) {
            return;
        }
        list.add(grid[r][c]);
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        backtrace(grid, r + 1, c, list, res);
        backtrace(grid, r, c + 1, list, res);
        list.remove(list.size() - 1);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String s = new String(tmp);

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        map.put(s.charAt(0), 0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                int tmp = map.get(s.charAt(i));
                for (int j = left; j <= tmp; j++) {
                    map.remove(s.charAt(j));
                }
                left = tmp + 1;
            }
            map.put(s.charAt(i), i);
            count = Math.max(i - left + 1, count);

        }
        return count;
    }

    static String[] index = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> res1 = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {

        backtrace(digits, new StringBuilder());
        return res1;
    }

    public static void backtrace(String digits, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res1.add(sb.toString());
            return;
        }

        int idx = digits.charAt(sb.length()) - '0';
        String tmp = index[idx];
        for (int i = 0; i < tmp.length(); i++) {
            sb.append(tmp.charAt(i));
            backtrace(digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int max = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            int ji = centerExpand(s, i, i);
            int ou = centerExpand(s, i, i + 1);
            if (max < Math.max(ji, ou)) {
                max = Math.max(ji, ou);
                if (ji >= ou) {
                    res = s.substring(i - ji / 2, i + ji / 2 + 1);
                } else {
                    res = s.substring(i - ou / 2 + 1, i + ou / 2 + 1);
                }
            }
        }
        return res;

    }

    public static int centerExpand(String s, int l, int r) {
        if (l != r && s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        //窗口左边界
        int left = 0;
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            int tmp = i - 1;
            //当前字符和窗口内字符串是否存在重复字符
            while (tmp >= left) {
                if (s.charAt(i) == s.charAt(tmp)) {
                    left++;
                    break;
                } else {
                    count = Math.max(count, i - tmp + 1);
                }
                tmp--;
            }

        }

        return count;
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
