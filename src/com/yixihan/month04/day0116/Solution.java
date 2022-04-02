package com.yixihan.month04.day0116;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 *
 * 实现 Solution 类：
 *
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 *
 * @author : yixihan
 * @create : 2022-01-16-7:05
 */
public class Solution {

    List<ListNode> values;

    public Solution(ListNode head) {
        values = new LinkedList<> ();

        while (head != null) {
            values.add (head);
            head = head.next;
        }
    }

    public int getRandom() {
        Random random = new Random();

        return values.get (random.nextInt (values.size ())).val;
    }
}


class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
