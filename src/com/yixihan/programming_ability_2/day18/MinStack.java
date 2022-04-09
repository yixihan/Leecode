package com.yixihan.programming_ability_2.day18;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author : yixihan
 * @create : 2022-04-09-13:18
 */
public class MinStack {

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<> ();
    }

    public void push(int val) {
        int minVal = val;
        if (!stack.isEmpty ()) {
            minVal = Math.min (getMin (), minVal);
        }
        stack.push (new Node (val, minVal));
    }

    public void pop() {
        if (!stack.isEmpty ()) {
            stack.pop ();
        }
    }

    public int top() {
        if (!stack.isEmpty ()) {
            return stack.peek ().val;
        }
        return -1;
    }

    public int getMin() {
        if (!stack.isEmpty ()) {
            return stack.peek ().minVal;
        }
        return -1;
    }

    class Node {
        int val;
        int minVal;

        public Node() {
        }

        public Node(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }
}
