package com.yixihan.satine;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

 *
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 *
 *  输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 *
 * @author : yixihan
 * @create : 2022-03-09-14:42
 */
public class SortedStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public SortedStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<> ();
    }

    public void push(int val) {
        if (stack1.isEmpty ()) {
            stack1.push (val);
            return;
        }

        while (! isEmpty() && peek () < val) {
            stack2.push (stack1.pop ());
        }

        stack1.push (val);

        while (! stack2.isEmpty ()) {
            stack1.push (stack2.pop ());
        }
    }

    public void pop() {
        if (! isEmpty ()) {
            stack1.pop ();
        }
    }

    public int peek() {
        return isEmpty () ? -1 : stack1.peek ();
    }

    public boolean isEmpty() {
        return stack1.isEmpty ();
    }
}
