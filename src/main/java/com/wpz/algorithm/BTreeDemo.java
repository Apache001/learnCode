package com.wpz.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import sun.reflect.generics.tree.Tree;

/**
 * @author wangpengzhe
 * @description 二叉搜索树
 * @date 2019/11/21 16:07
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class BTreeDemo {

    TreeNode root = null;

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 10, 20, 16};
        BTreeDemo tree = new BTreeDemo();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        tree.afterPrint(tree.root);
        System.out.println();
        tree.cnegcePrint(tree.root);
    }

    class TreeNode {

        int data;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.data < data) {
                if (tmp.rightNode == null) {
                    tmp.rightNode = new TreeNode(data);
                    return;
                }
                tmp = tmp.rightNode;
            } else {
                if (tmp.leftNode == null) {
                    tmp.leftNode = new TreeNode(data);
                    return;
                }
                tmp = tmp.leftNode;
            }
        }
    }

    private void prePrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        prePrint(root.leftNode);
        prePrint(root.rightNode);
    }

    private void midPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        midPrint(root.leftNode);
        System.out.print(root.data + "->");
        midPrint(root.rightNode);
    }

    private void afterPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        afterPrint(root.leftNode);
        afterPrint(root.rightNode);
        System.out.print(root.data + "->");
    }

    private void cnegcePrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.data + "->");
            if (poll.leftNode != null) {
                queue.offer(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.offer(poll.rightNode);
            }
        }
    }

}
