package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wpz
 * @Desctription: 给定一个二叉树，返回所有从根节点到叶子节点的路径
 * @Date: Created in 2019/12/17 22:02
 */
public class L257 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }

        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String sb) {
        if (root == null) {
            return;
        }
        sb = sb + root.val + "->";
        if (root.left == null && root.right == null) {
            res.add(sb.substring(0, sb.length() - 2));
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

}
