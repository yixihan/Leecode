package com.yixihan.random.day0905;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 *
 * @author : yixihan
 * @create : 2022-09-05-13:40
 */
public class MyStack {

    Queue<Integer> queue1 = new LinkedList<> ();
    Queue<Integer> queue2 = new LinkedList<> ();

    public MyStack() {

    }

    public void push(int x) {
        queue1.add (x);

        while (!queue2.isEmpty ()) {
            queue1.add (queue2.poll ());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public int pop() {
        return queue2.isEmpty () ? -1 : queue2.poll ();
    }

    public int top() {
        return queue2.isEmpty () ? -1 : queue2.peek ();
    }

    public boolean empty() {
        return queue1.isEmpty () && queue2.isEmpty ();
    }
}
