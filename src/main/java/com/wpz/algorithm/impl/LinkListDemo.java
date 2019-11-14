package com.wpz.algorithm.impl;

import com.wpz.algorithm.ILinklist;
import com.wpz.algorithm.LinkListNode;

import java.awt.*;


/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/11/14 21:19
 */
public class LinkListDemo implements ILinklist {

    public static void main(String[] args) {
        LinkListDemo linkList = new LinkListDemo();
        linkList.insertHead(1);
        linkList.insertHead(2);
        linkList.insertHead(3);
        linkList.insertHead(4);

        linkList.print(linkList.head);
        System.out.println();

        linkList.insert(linkList.head, 8, 4);
        linkList.print(linkList.head);
        System.out.println();

        linkList.del(linkList.head,1);
        linkList.print(linkList.head);
    }

    private LinkListNode head = null;


    @Override
    public void insertHead(int data) {
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
    public void insertTail(int data) {
        LinkListNode newNode = new LinkListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void insert(LinkListNode head, int data, int index) {
        if (index < 0 || index > this.getLength(head)) {
            throw new IllegalArgumentException("插入位置不存在");
        }
        LinkListNode tmp = head;
        int count = 1;
        while (count < index) {
            tmp = tmp.next;
            count++;
        }
        LinkListNode newNode = new LinkListNode(data);
        newNode.next = tmp.next;
        tmp.next = newNode;
    }

    @Override
    public void del(LinkListNode head, int data) {
        if (head == null) {
            return;
        }
        if (head.getData() == data) {
            head = head.next;
            return;
        }
        LinkListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.getData() == data) {
                tmp.next = tmp.next.next;
                return;
            }
            tmp = tmp.next;
        }
    }

    @Override
    public void print(LinkListNode head) {
        if (head == null) {
            System.out.println("链表为空");
        }
        LinkListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getData() + "->");
            tmp = tmp.next;
        }
    }

    @Override
    public void search(int data) {

    }

    @Override
    public int getLength(LinkListNode head) {
        int count = 0;
        LinkListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    @Override
    public void reverse(LinkListNode head) {

    }
}
