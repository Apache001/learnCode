package com.wpz.OfferQuestion;

import java.util.Stack;

/**
 * @Author: wpz
 * @Desctription: 用两个栈实现队列
 * @Date: Created in 2019/12/7 22:29
 */
public class Question9 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    static class MyQueue {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        private void offer(int data) {
            stackA.push(data);
        }

        private Integer poll() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty()) {
                    return null;
                }
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }
            return stackB.pop();
        }

    }

}
