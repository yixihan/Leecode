package com.yixihan.programming_ability_2.day14;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 * @author : yixihan
 * @create : 2022-04-05-14:59
 */
public class ReorderList {

    /**
     * 快慢指针找到中点, 将链表分成两段, 后一段反转, 然后拼接
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;

        // 找到中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 分为两段链表, 并反转后一段链表
        ListNode reverseList = slow.next;
        slow.next = null;
        reverseList = reverseList (reverseList);

        // 拼接两段链表
        ListNode cur = head;
        while (cur != null && reverseList != null) {
            ListNode curSecond = reverseList;
            reverseList = reverseList.next;
            ListNode nextCur = cur.next;
            curSecond.next = cur.next;
            cur.next = curSecond;
            cur = nextCur;
        }

    }

    private ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode next = null;
        ListNode pre = null;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
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
