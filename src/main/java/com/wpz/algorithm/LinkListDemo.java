package com.wpz.algorithm;


/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/11/14 21:19
 */
public class LinkListDemo {

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

//        Node head = linkList.del(linkList.head, 2);
//        linkList.print(head);

        int index = linkList.search(linkList.head,4);
        System.out.println(index);
    }

    /**
     * 头结点
     */
    Node head = null;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insertHead(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public void insertTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insert(Node head, int data, int index) {
        if (index < 0 || index > this.getLength(head)) {
            throw new IllegalArgumentException("插入位置不存在");
        }
        Node tmp = head;
        int count = 1;
        while (count < index) {
            tmp = tmp.next;
            count++;
        }
        Node newNode = new Node(data);
        newNode.next = tmp.next;
        tmp.next = newNode;
    }

    public Node del(Node head, int data) {
        if (head == null) {
            return head;
        }
        if (head.data == data) {
            head = head.next;
            return head;
        }
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.next.data == data) {
                tmp.next = tmp.next.next;
                return head;
            }
            tmp = tmp.next;
        }
        return head;
    }

    public void print(Node head) {
        if (head == null) {
            System.out.println("链表为空");
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
    }

    public int search(Node head, int data) {
        Node tmp = head;
        int index = 1;
        while (head != null) {
            if (tmp.data == data) {
                return index;
            }
            index++;
            tmp = tmp.next;
        }
        return -1;
    }

    public int getLength(Node head) {
        int count = 0;
        Node tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public void reverse(Node head) {

    }
}
