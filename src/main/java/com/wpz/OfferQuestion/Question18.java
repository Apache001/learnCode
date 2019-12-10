package com.wpz.OfferQuestion;

/**
 * @Author: wpz
 * @Desctription: O(1)时间复杂度删除链表一个节点
 * @Date: Created in 2019/12/9 21:31
 */
public class Question18 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        deleteNode(root, node3);
        print(root);
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static void deleteNode(Node root, Node delNode) {
        if (delNode.next == null) {
            if (root == delNode) {
                root = null;
            } else {
                Node tmp = root;
                while (tmp.next != delNode) {
                    tmp = tmp.next;
                }
                tmp.next = null;
            }
        } else {
            Node next = delNode.next;
            delNode.data = next.data;
            delNode.next = next.next;
        }
    }

    private static Node deleteDuplicates(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root.next;
        Node pre = root;
        while (cur != null) {
            if (cur.data == pre.data) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return root;
    }

    private static void print(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        print(root.next);
    }
}
