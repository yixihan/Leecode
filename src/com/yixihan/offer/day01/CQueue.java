package com.yixihan.offer.day01;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * @author : yixihan
 * @create : 2022-02-21-11:42
 */
public class CQueue {

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<> ();
        stack2 = new LinkedList<> ();
    }

    public void appendTail(int value) {
        stack1.addLast (value);
    }

    public int deleteHead() {

        if (!stack2.isEmpty ()) {
            return stack2.removeLast ();
        }
        if (stack1.isEmpty ()) {
            return -1;
        }
        while (!stack1.isEmpty ()) {
            stack2.addLast (stack1.removeLast ());
        }

        return stack2.removeLast ();

    }
}
