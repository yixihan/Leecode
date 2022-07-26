package com.yixihan.random.day0726;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * @author : yixihan
 * @create : 2022-07-26-8:53
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode (-1, head);
        ListNode node1 = node;
        ListNode node2 = node;
        int index = 0;

        while (index++ <= n) {
            node2 = node2.next;
        }

        while (node2 != null) {
            node2 = node2.next;
            node1 = node1.next;
        }

        node1.next = node1.next.next;

        return node.next;
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
}
