package com.yixihan.data_structure_1.day7;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-03-16-14:24
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode node = head.next;

        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                node = pre.next;
                continue;
            }

            pre = node;
            node = node.next;

        }

        return head.val == val ? head.next : head;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
