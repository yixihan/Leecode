package com.yixihan.offer.day28;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入: 
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入: 
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 * @author : yixihan
 * @create : 2022-03-19-10:54
 */
public class MaxQueue {

    // 方法一 : 耍赖法, 维护一个 treeMap
//    Deque<Integer> queue = new ArrayDeque<> ();
//    TreeMap<Integer, Integer> map = new TreeMap<> ();
//
//    public MaxQueue() {
//
//    }
//
//    public int max_value() {
//        if (queue.isEmpty () && map.isEmpty ()) {
//            return -1;
//        }
//        return map.lastKey ();
//    }
//
//    public void push_back(int value) {
//        queue.addLast (value);
//        map.put (value, map.getOrDefault (value, 0) + 1);
//    }
//
//    public int pop_front() {
//        if ( queue.isEmpty ()) {
//            return -1;
//        }
//        Integer val = queue.removeFirst ();
//        Integer count = map.get (val);
//        if (count <= 1) {
//            map.remove (val);
//        } else {
//            map.put (val, count - 1);
//        }
//        return val;
//    }

    // 方法二 : 滑动窗口
    private Deque<Integer> queue;
    private Deque<Integer> help;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        int val = queue.pop();
        if(help.peek() == val) {
            help.pop();
        }
        return val;
    }
}
