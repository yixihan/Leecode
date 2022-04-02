package com.yixihan.offer.day12;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author : yixihan
 * @create : 2022-03-04-13:03
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode (0);
        ListNode head = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = new ListNode (l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode (l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }

        while (l1 != null) {
            node.next = new ListNode (l1.val);
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = new ListNode (l2.val);
            node = node.next;
            l2 = l2.next;
        }

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
