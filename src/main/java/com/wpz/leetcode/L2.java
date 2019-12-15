package com.wpz.leetcode;

/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/12/13 21:56
 */
public class L2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(6);

        ListNode node2 = new ListNode(7);
//        ListNode node3 = new ListNode(3);
//        node2.next = node3;
        ListNode listNode = addTwoNumbers(node1, node2);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int jinwei = 0;
        ListNode root = l1;
        ListNode cursor = root;
        ListNode pre = root;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + jinwei;
            if (cursor == null) {
                if (l2 != null) {
                    cursor = l2;
                    pre.next=l2;
                }
            }
            cursor.val = sum % 10;
            jinwei = sum / 10;
            pre = cursor;
            cursor = cursor.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (jinwei != 0) {
            pre.next = new ListNode(jinwei);
        }

        return root;
    }
}
