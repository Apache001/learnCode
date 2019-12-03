package com.wpz.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangpengzhe
 * @description
 * @date 2019/12/2 14:20
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class GraphDemo {

    private int v;
    //使用邻接表存储
    private LinkedList<Integer>[] adj;

    GraphDemo(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图添加一条边
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先遍历
     *
     * @return void
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //节点是否已访问过
        boolean[] visited = new boolean[v];
        //当前节点的上一个节点
        int[] pre = new int[v];
        for (int i = 0; i < v; ++i) {
            pre[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    pre[q] = w;
                    if (q == t) {
                        this.printbfs(pre, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }

    }

    /**
     * 深度优先遍历
     *
     * @return void
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int prev[] = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        findRec(s, t, visited, prev);
        printbfs(prev, s, t);
    }

    boolean success = false;

    private void findRec(int s, int t, boolean[] visited, int[] prev) {
        if (success) {
            return;
        }
        visited[s] = true;
        if (s == t) {
            success = true;
            return;
        }
        for (int i = 0; i < adj[s].size(); i++) {
            int q = adj[s].get(i);
            if (!visited[q]) {
                prev[q] = s;
                findRec(q, t, visited, prev);
            }
        }

    }

    private void printbfs(int[] pre, int s, int t) {
        if (pre[t] != -1 && s != t) {
            printbfs(pre, s, pre[t]);
        }
        System.out.println(t + " ");
    }

    static List<List<Integer>> res = new ArrayList<>();


    public static void main(String[] args) {
        int[] nums={1,2,3};
        quan(nums);
        System.out.println(res);
    }

    public static void quan(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(0, nums, list);

    }

    public static void backtrack(int n, int[] nums, List<Integer> list) {
        if (nums.length == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrack(n + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
