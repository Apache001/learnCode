package com.wpz.algorithm.impl;

import com.wpz.algorithm.ILinklist;
import com.wpz.algorithm.LinkListNode;

/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/11/14 21:19
 */
public class LinkListDemo implements ILinklist {

    class Node {
        int data;
        Node next;
    }

    private LinkListNode head = null;


    @Override
    public void insertTail(int data) {
        LinkListNode node = new LinkListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        LinkListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    @Override
    public void insertHead(int data) {

    }

    @Override
    public void insert(int data, int index) {

    }

    @Override
    public void del(int data) {

    }

    @Override
    public void print(LinkListNode head) {

    }

    @Override
    public void searche(int data) {

    }

    @Override
    public void getLength(LinkListNode head) {

    }

    @Override
    public void reverse(LinkListNode head) {

    }
}
