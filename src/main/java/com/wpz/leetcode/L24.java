package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * @date 2019/11/28 16:26
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L24 {

    public static void main(String[] args) {

    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head.next;
        head.next = swapPairs(t.next);
        t.next = head;
        return t;
    }
}
