package com.yixihan.data_structure_1.day8;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 输入：head = []
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-03-17-13:46
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
