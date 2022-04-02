package com.yixihan.satine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : yixihan
 * @create : 2022-03-07-19:19
 */
public class StackOfPlates {

    List<MyStack> stacks = new ArrayList<>();
    int maxSize;

    public StackOfPlates(int cap) {
        maxSize = cap;
    }

    public void push(int val) {
        if (maxSize == 0) {
            return;
        }
        if (stacks.isEmpty () || stacks.get (stacks.size () - 1).isFull ()) {
            stacks.add (new MyStack());
        }

        stacks.get (stacks.size () - 1).push (val);
    }

    public int pop() {
        return popAt (stacks.size () - 1);
    }

    public int popAt(int index) {
        if (maxSize == 0 || stacks.isEmpty () || index < 0 || index >= stacks.size ()) {
            return -1;
        }

        int val = stacks.get (index).pop ();
        if (stacks.get (index).isEmpty ()) {
            stacks.remove (index);
        }

        return val;
    }

    class MyStack {
        Stack<Integer> stack;
        int size;

        public MyStack () {
            stack = new Stack<>();
        }

        public boolean isEmpty () {
            return size == 0;
        }

        public boolean isFull () {
            return size == maxSize;
        }

        public void push (int val) {
            stack.push (val);
            size++;
        }

        public int pop () {
            size--;
            return stack.pop ();
        }
    }
}

