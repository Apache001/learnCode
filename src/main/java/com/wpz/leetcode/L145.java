package com.wpz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangpengzhe
 * @description 给定一个二叉树，返回它的后序 遍历。
 * @date 2019/11/26 20:21
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L145 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return list;
        }

        postorderTraversal(root.left);
        list.add(root.val);
        postorderTraversal(root.right);

        return list;
    }
}
