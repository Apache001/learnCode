package com.wpz.OfferQuestion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wpz
 * @Desctription: 根据先序和中序遍历重建二叉树
 * @Date: Created in 2019/12/7 21:43
 */
public class Question7 {
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] minOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        Node root = buildTree(preOrder, minOrder);
        print(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(int[] pre, int[] mid) {
        if (pre == null || mid == null) {
            return null;
        }
        Node root = reBuildTreeRecurse(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
        return root;
    }

    private static Node reBuildTreeRecurse(int[] pre, int pStart, int pEnd, int[] mid, int mStart, int mEnd) {
        if (pStart > pEnd || mStart > mEnd) {
            return null;
        }
        Node root = new Node(pre[pStart]);
        for (int i = mStart; i <= mEnd; i++) {
            if (mid[i] == pre[pStart]) {
                root.left = reBuildTreeRecurse(pre, pStart + 1, pStart + (i - mStart), mid, mStart, i - 1);
                root.right = reBuildTreeRecurse(pre, pStart + (i - mStart) + 1, pEnd, mid, i + 1, mEnd);
            }
        }
        return root;
    }

    private static void print(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null) {
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                queue.offer(tmp.right);
            }

        }
    }
}
