package com.yixihan.programming_ability_2.day16;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * @author : yixihan
 * @create : 2022-04-07-15:29
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int size = getListSize (head);
        ListNode node = head;
        ListNode cloneNode = cloneList (head);

        while (node.next != null) {
            node = node.next;
        }
        node.next = cloneNode;
        node = head;
        // show (node);
        k = k % size;

        int index = 0;
        while (index < size - k) {
            node = node.next;
            index++;
        }
        ListNode ans = node;

        index = 1;
        while (index < size) {
            node = node.next;
            index++;
        }
        node.next = null;
        return ans;
    }

    private int getListSize(ListNode head) {
        ListNode node = head;
        int size = 0;

        while (node != null) {
            size++;
            node = node.next;
        }

        return size;
    }

    private ListNode cloneList(ListNode head) {
        ListNode cloneHead = new ListNode (head.val);
        ListNode cloneNode = cloneHead;
        ListNode node = head.next;
        while (node != null) {
            cloneNode.next = new ListNode (node.val);
            cloneNode = cloneNode.next;
            node = node.next;
        }

        return cloneHead;
    }

    private void show(ListNode head) {
        ListNode node = head;

        while (node != null) {
            System.out.print (node.val + " -> ");
            node = node.next;
        }

        System.out.println ();
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
