package com.yixihan.programming_ability_2.day15;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * @author : yixihan
 * @create : 2022-04-06-14:32
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse (l1);
        l2 = reverse (l2);

        return reverse (add (l1, l2));
    }

    public ListNode add(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode ();
        ListNode node = ans;
        int sum = 0;

        while (l1 != null || l2 != null || sum != 0) {
            int val = sum;
            val += l1 == null ? 0 : l1.val;
            val += l2 == null ? 0 : l2.val;

            sum = val / 10;
            val = val % 10;

            node.next = new ListNode (val);
            node = node.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return ans.next;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        ListNode next = null;

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
