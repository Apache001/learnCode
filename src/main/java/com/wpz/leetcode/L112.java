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

        int tmp = 0;
        return dfs(root, sum, tmp);
    }

    private boolean dfs(TreeNode root, int sum, int tmp) {
        if (root == null && sum == tmp) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (tmp > sum) {
            return false;
        }
        if (dfs(root.left, sum, tmp + root.left.val)) {
            return true;
        } else {
            tmp -= root.left.val;
        }
        if (dfs(root.right, sum, tmp + root.right.val)) {
            return true;
        } else {
            tmp -= root.right.val;
        }
        return false;
    }
}
