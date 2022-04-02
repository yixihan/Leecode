package com.yixihan.data_structure_1.day7;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * @author : yixihan
 * @create : 2022-03-16-14:22
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode ();
        ListNode node = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                node.next = new ListNode (list2.val);
                list2 = list2.next;
                node = node.next;
            } else {
                node.next = new ListNode (list1.val);
                list1 = list1.next;
                node = node.next;
            }
        }

        while (list1 != null) {
            node.next = new ListNode (list1.val);
            list1 = list1.next;
            node = node.next;
        }

        while (list2 != null) {
            node.next = new ListNode (list2.val);
            list2 = list2.next;
            node = node.next;
        }

        return head.next;
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
