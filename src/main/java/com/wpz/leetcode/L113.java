package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wpz
 * @Desctription: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @Date: Created in 2019/12/17 21:39
 */
public class L113 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }

        dfs(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<>(list));
        }

        dfs(root.left, sum - root.val, list);
        dfs(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}

