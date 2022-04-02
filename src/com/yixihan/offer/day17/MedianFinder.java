package com.yixihan.offer.day17;

import java.util.PriorityQueue;

/**
 * @author : yixihan
 * @create : 2022-03-09-12:05
 */
public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        left = new PriorityQueue<> ((n1, n2) -> n2 - n1);
        right = new PriorityQueue<> ();
    }

    public void addNum(int num) {
        left.add (num);
        right.add (left.poll ());

        if (left.size () + 1 < right.size ()) {
            left.add (right.poll ());
        }

    }

    public double findMedian() {
        if (right.size () > left.size ()) {
            return right.peek ();
        }
        return (double) (left.peek () + right.peek ()) / 2;
    }
}
