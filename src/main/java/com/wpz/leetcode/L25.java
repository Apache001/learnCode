package com.wpz.leetcode;


/**
 * @author wangpengzhe
 * @description 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表
 * @date 2019/11/28 19:35
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L25 {

    public static void main(String[] args) {

    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;

        while (pointer != null) {
            ListNode lastGroup = pointer;
            int i = 0;
            for (; i < k; i++) {
                pointer = pointer.next;
                if (pointer == null) {
                    break;
                }
            }
            if (i == k) {
                ListNode nextGroup = pointer.next;
                ListNode newNode = reserve(lastGroup.next, nextGroup);
                pointer = lastGroup.next;
                lastGroup.next = newNode;
                pointer.next = nextGroup;
            }
        }
        return dummy.next;
    }

    private ListNode reserve(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
