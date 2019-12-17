package com.wpz.leetcode;


/**
 * @author wangpengzhe
 * @description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @date 2019/12/17 20:30
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L112 {

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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else if (root.left == null && root.right == null) {
            return false;
        }

        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);

    }
}
