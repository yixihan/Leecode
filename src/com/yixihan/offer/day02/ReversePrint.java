package com.yixihan.offer.day02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author : yixihan
 * @create : 2022-02-22-12:34
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {

        ListNode node = head;
        int length = 0;

        while (node != null) {
            length++;
            node = node.next;
        }

        int[] ans = new int[length];
        node = head;

        for (int i = length - 1; i >= 0 ; i--) {
            ans[i] = node.val;
            node = node.next;
        }

        return ans;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }
}


