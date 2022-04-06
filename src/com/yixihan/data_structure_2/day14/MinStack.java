package com.yixihan.data_structure_2.day14;

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
 * @create : 2022-04-06-13:24
 */
public class MinStack {

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<> ();
    }

    public void push(int val) {
        int minVal = Integer.MAX_VALUE;
        if (!stack.isEmpty ()) {
            minVal = stack.peek ().minVal;
        }
        minVal = Math.min (val, minVal);

        stack.push (new Node (val, minVal));

    }

    public void pop() {
        stack.pop ();
    }

    public int top() {
        return stack.peek ().val;
    }

    public int getMin() {
        return stack.peek ().minVal;
    }

    class Node {
        int val;
        int minVal;

        public Node(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }
}
