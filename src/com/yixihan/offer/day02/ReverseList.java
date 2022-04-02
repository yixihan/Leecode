package com.yixihan.offer.day02;

import java.util.LinkedList;
import java.util.List;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author : yixihan
 * @create : 2022-02-22-12:46
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

}
