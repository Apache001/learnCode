package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定两个二叉树，编写一个函数来检验它们是否相同。 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @date 2019/12/6 10:29
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L100 {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
