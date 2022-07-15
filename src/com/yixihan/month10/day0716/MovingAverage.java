package com.yixihan.month10.day0716;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，
 * 请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 * <p>
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 *
 * @author : yixihan
 * @create : 2022-07-16-7:31
 */
public class MovingAverage {

    Queue<Integer> queue = new ArrayDeque<> ();
    int size;
    int capacity;
    int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.capacity = size;
        this.size = 0;
        this.sum = 0;
    }

    public double next(int val) {
        if (size < capacity) {
            size++;
        } else {
            sum -= queue.remove ();
        }
        queue.add (val);
        sum += val;

        return sum / (double) size;
    }
}
