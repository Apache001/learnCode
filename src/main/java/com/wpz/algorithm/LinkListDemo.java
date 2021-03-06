package com.wpz.algorithm;


import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/11/14 21:19
 */
public class LinkListDemo {

    public static void main(String[] args) {
        LinkListDemo linkList = new LinkListDemo();
        linkList.insertTail(1);
        linkList.insertTail(2);
        linkList.insertTail(3);
        linkList.insertTail(4);
        linkList.insertTail(5);
        linkList.insertTail(6);
        linkList.insertTail(7);

        linkList.print(linkList.head);
        linkList.printReverseRecurse(linkList.head);

//        linkList.insert(linkList.head, 8, 4);
//        linkList.print(linkList.head);

//        Node head = linkList.del(linkList.head, 2);
//        linkList.print(head);

//        int index = linkList.search(linkList.head, 4);
//        System.out.println(index);
//
//        Node head = linkList.reverseRecurce(linkList.head);
//        linkList.print(head);
//
//        boolean b = linkList.circleList(linkList.head);
//        System.out.println(b);
//
//        int i = linkList.circleLength(linkList.head);
//        System.out.println(i);

//        Node k = linkList.getK(linkList.head, 4);
//        System.out.println(k.data);


//        LinkListDemo linkList1 = new LinkListDemo();
//        linkList1.insertHead(3);
//        linkList1.insertHead(8);
//        linkList1.insertHead(10);
//        linkList1.insertHead(12);
//
//        LinkListDemo linkList2 = new LinkListDemo();
//        linkList2.insertHead(1);
//        linkList2.insertHead(4);
//        linkList2.insertHead(20);
//        Node node = linkList.mergeList(linkList1.head, linkList2.head);
//        linkList.print(node);

//        Node node = linkList.reverseK(linkList.head, 2);
//        linkList.print(node);
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

    /**
     * 尾部插入节点
     *
     * @param data
     */
    public void insertTail(int data) {
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

    /**
     * 头部插入节点
     *
     * @param data
     */
    public void insertHead(int data) {
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

    private void print(Node head) {
        if (head == null) {
            System.out.println("链表为空");
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * 逆序打印单链表(递归)
     *
     * @param head
     */
    private void printReverseRecurse(Node head) {
        if (head == null) {
            return;
        }

        printReverseRecurse(head.next);
        System.out.print(head.data + "->");
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

    /**
     * 反转单链表
     *
     * @param head
     */
    public Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return pre;
    }

    /**
     * 反转单链表(递归)
     *
     * @param head
     * @return
     */
    Node reverseRecurce(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tmp = head.next;
        Node newHead = reverseRecurce(head.next);
        tmp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    boolean circleList(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 求环形链表环的长度
     *
     * @param head
     * @return
     */
    int circleLength(Node head) {
        if (!circleList(head)) {
            return 0;
        }
        Node fast = head;
        Node slow = head;
        int count = 0;
        boolean start = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                if (start) {
                    return count;
                }
                start = true;
            }
            if (start) {
                count++;
            }
        }
        return 0;
    }

    /**
     * 求链表倒数第k个节点
     *
     * @param head
     */
    Node getK(Node head, int k) {
        if (k < 0) {
            throw new IllegalArgumentException("参数不合法");
        }
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("参数不合法");
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 求链表中间节点
     *
     * @param head
     * @return
     */
    Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除链表重复元素
     *
     * @param head
     * @return
     */
    Node deleteDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            if (cur.data == pre.data) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }

    /**
     * 合并两个有序单链表(递归)
     *
     * @param head1
     * @param head2
     * @return
     */
    Node mergeListRecurse(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node resultHead = null;

        if (head1.data <= head2.data) {
            resultHead = head1;
            resultHead.next = mergeListRecurse(head1.next, head2);
        }
        if (head1.data > head2.data) {
            resultHead = head2;
            resultHead.next = mergeListRecurse(head1, head2.next);
        }
        return resultHead;
    }

    /**
     * 合并两个有序单链表(非递归)
     *
     * @param head1
     * @param head2
     * @return
     */
    Node mergeList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node result = null;
        if (head1.data <= head2.data) {
            result = head1;
            head1 = head1.next;
        } else {
            result = head2;
            head2 = head2.next;
        }

        Node tmp = result;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tmp.next = head1;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if (head1 == null) {
            tmp.next = head2;
        }
        if (head2 == null) {
            tmp.next = head1;
        }
        return result;
    }

    /**
     * k个一组反转链表
     *
     * @param head
     * @return
     */
    Node reverseK(Node head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pointer = dummy;

        while (pointer != null) {
            Node lastGroup = pointer;
            int i = 0;
            for (; i < k; i++) {
                pointer = pointer.next;
                if (pointer == null) {
                    break;
                }
            }
            if (i == k) {
                Node nextGroup = pointer.next;
                Node newNode = reverse1(lastGroup.next, nextGroup);
                pointer = lastGroup.next;
                lastGroup.next = newNode;
                pointer.next = nextGroup;
            }
        }
        return dummy.next;
    }

    private Node reverse1(Node head, Node tail) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null, temp = null;
        while ((head != null) && (head != tail)) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    /**
     * 合并k个有序链表
     *
     * @param heads
     * @return
     */
    Node mergeKList(Node[] heads) {
        if (heads == null || heads.length == 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Node node : heads) {
            while (node != null) {
                queue.add(node.data);
                node = node.next;
            }
        }
        Node result = new Node(queue.poll());
        Node tmp = result;
        while (!queue.isEmpty()) {
            Node newNode = new Node(queue.poll());
            tmp.next = newNode;
            tmp = newNode;
        }
        return result;
    }
}
