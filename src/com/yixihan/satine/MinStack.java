package com.yixihan.satine;

import java.util.Stack;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
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
 * @create : 2022-03-07-13:35
 */
public class MinStack {
    Stack<MyStack> stack;
    int minVal = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        minVal = Math.min(x, minVal);

        stack.push(new MyStack (x, minVal));
    }

    public void pop() {
        stack.pop();
        if (stack.isEmpty ()) {
            minVal=Integer.MAX_VALUE;
        } else {
            minVal=stack.peek().minValue;
        }
    }

    public int top() {
        MyStack val = stack.peek ();
        return val.val;
    }

    public int getMin() {
        MyStack val = stack.peek ();
        return val.minValue;
    }

    class MyStack {
        int val;
        int minValue;

        public MyStack (int val, int minValue) {
            this.val = val;
            this.minValue = minValue;
        }
    }
}
