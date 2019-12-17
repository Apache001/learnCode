package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个非空二叉树，返回其最大路径和
 * @date 2019/12/17 18:03
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L124 {

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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recurse(root);
        return max;
    }

    private int recurse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(recurse(root.left), 0);
        int right = Math.max(recurse(root.right), 0);
        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
