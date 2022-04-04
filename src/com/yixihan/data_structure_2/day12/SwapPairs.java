package com.yixihan.data_structure_2.day12;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *
 * @author : yixihan
 * @create : 2022-04-04-14:33
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = null;
        ListNode pre = head;
        ListNode node = head.next;
        ListNode next = null;
        ListNode ans = node;

        while (node != null) {
            next = node.next;

            node.next = pre;
            pre.next = next;
            if (cur != null) {
                cur.next = node;
            }
            if (next == null || next.next == null) {
                break;
            }
            cur = pre;
            pre = next;
            node = pre.next;
            next = node.next;

        }

        return ans;
    }

    public class ListNode {
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
