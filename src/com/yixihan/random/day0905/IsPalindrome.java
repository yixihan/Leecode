package com.yixihan.random.day0905;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-09-05-14:07
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode node = head;
        ListNode reverseNode = reverse (head);

        while (node != null && reverseNode != null) {
            if (node.val != reverseNode.val) {
                return false;
            }
            node = node.next;
            reverseNode = reverseNode.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode node = head;
        ListNode newHead = new ListNode ();
        ListNode cur = null;

        while (node != null) {
            cur = new ListNode (node.val, cur);
            newHead.next = cur;
            node = node.next;
        }

        return newHead.next;
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
