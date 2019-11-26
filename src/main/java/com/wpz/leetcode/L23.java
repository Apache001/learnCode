package com.wpz.leetcode;

import java.util.PriorityQueue;

/**
 * @author wangpengzhe
 * @description 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * @date 2019/11/26 17:44
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L23 {

    public static void main(String[] args) {

    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(queue.poll());
        ListNode p = head;
        while (!queue.isEmpty()) {
            ListNode newNode = new ListNode(queue.poll());
            p.next = newNode;
            p = newNode;
        }
        return head;
    }
}
