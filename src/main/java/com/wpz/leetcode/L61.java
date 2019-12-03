package com.wpz.leetcode;

/**
 * @author wangpengzhe
 * @description 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @date 2019/11/29 15:57
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class L61 {

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = null;
        System.out.println(rotateRight(a,4).val);
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode l = head;
        ListNode end = null;
        while (l != null) {
            end = l;
            l = l.next;
            count++;
        }
        end.next = head;
        ListNode tmp = head;
        for (int i = 0; i < k % count; i++) {
            tmp = tmp.next;
        }
        ListNode p = head;
        while (tmp != end) {
            tmp = tmp.next;
            p = p.next;
        }
        ListNode newNode = p.next;
        p.next = null;
        return newNode;
    }

}
