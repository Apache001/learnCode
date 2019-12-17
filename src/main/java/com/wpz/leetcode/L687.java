package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 最长同值路径
 * @date 2019/12/13 19:53
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L687 {

    public static void main(String[] args) {

    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        recuse(root);
        return max;
    }

    private int recuse(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null && root.val == root.left.val) {
            left = 1 + recuse(root.left);
        } else if (root.left != null) {
            recuse(root.left);
        }

        if (root.right != null && root.val == root.right.val) {
            right = 1 + recuse(root.right);
        } else if (root.right != null) {
            recuse(root.right);
        }

        if (left + right > max) {
            max = left + right;
        }

        return left > right ? left : right;
    }
}
