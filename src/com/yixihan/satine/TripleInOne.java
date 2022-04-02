package com.yixihan.satine;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
 * stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * @author : yixihan
 * @create : 2022-03-07-13:31
 */
public class TripleInOne {
    int[] stack;
    int maxSize;
    int[] size;

    public TripleInOne(int stackSize) {
        stack = new int[stackSize * 3];
        maxSize = stackSize;
        size = new int[]{0, 0, 0};
    }

    public void push(int stackNum, int value) {
        if (size[stackNum] == maxSize) {
            return;
        }

        stack[stackNum * maxSize + size[stackNum]++] = value;

    }

    public int pop(int stackNum) {
        if (isEmpty (stackNum)) {
            return -1;
        }

        return stack[stackNum * maxSize + --size[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty (stackNum)) {
            return -1;
        }
        return stack[stackNum * maxSize + size[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return size[stackNum] == 0;
    }
}
