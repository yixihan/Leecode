package com.yixihan.offer.day01;

import org.w3c.dom.Node;

import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * @author : yixihan
 * @create : 2022-02-21-11:52
 */
public class MinStack {

    Node head;

    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node (x);
        } else {
            head = new Node (x, Math.min (x, head.minValue), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int min() {
        return head.minValue;
    }


    private class Node {

        private int minValue;

        private int value;

        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int minValue, int value, Node next) {
            this.minValue = minValue;
            this.value = value;
            this.next = next;
        }
    }
}
