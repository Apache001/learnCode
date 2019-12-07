package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: 从尾到头打印单链表
 * @Date: Created in 2019/12/7 16:48
 */
public class Question6 {
    public static void main(String[] args) {
        Node head = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        printReverse(head);
    }

    //单链表节点
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    //递归，也可以用栈
    public static void printReverse(Node head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.println(head.data);
    }
}
