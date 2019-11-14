package com.wpz.algorithm;

/**
 * @Author: wpz
 * @Desctription:
 * @Date: Created in 2019/11/14 21:23
 */
public interface ILinklist {

    /**
     * 尾部插入节点
     *
     * @param data
     */
    void insertTail(int data);

    /**
     * 头部插入节点
     *
     * @param data
     */
    void insertHead(int data);

    /**
     * 在指定位置插入节点
     *
     * @param data
     * @param index
     */
    void insert(int data, int index);

    /**
     * 删除指定节点
     *
     * @param data
     */
    void del(int data);

    /**
     * 打印单链表
     *
     * @param head
     */
    void print(LinkListNode head);

    /**
     * 查找节点
     *
     * @param data
     */
    void searche(int data);

    /**
     * 获取单链表长度
     *
     * @param head
     */
    void getLength(LinkListNode head);

    /**
     * 反转单链表
     *
     * @param head
     */
    void reverse(LinkListNode head);

}
