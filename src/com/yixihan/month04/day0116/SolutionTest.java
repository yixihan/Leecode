package com.yixihan.month04.day0116;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-16-7:10
 */
class SolutionTest {

    Solution test;

    @Test
    void getRandom() {

        ListNode head = new ListNode (1);
        head.next = new ListNode (2);
        head.next.next = new ListNode (3);

        test = new Solution (head);

        System.out.println (test.getRandom ());
        System.out.println (test.getRandom ());
        System.out.println (test.getRandom ());
        System.out.println (test.getRandom ());
        System.out.println (test.getRandom ());
        System.out.println (test.getRandom ());
    }
}