package com.yixihan.bishi.bilibili.q1;

/**
 * @author : yixihan
 * @create : 2022-09-20-19:11
 */
public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode longestList(ListNode head) {
        // write code here
        ListNode pre = null;
        ListNode node = head;
        ListNode next = node.next;

        while (next != null) {
            if ((node.val + next.val) % 2 != 0) {
                pre = node;
                node = next;
                next = node.next;
            } else {
                if (next.next == null) {
                    node.next = null;
                    next = null;
                } else if ((next.next.val + node.val) % 2 != 0) {
                    node.next = next.next;
                    next = node.next;
                } else if (pre != null && ((pre.val + next.val) % 2 != 0)) {
                    pre.next = next;
                    node = pre.next;
                    next = node.next;
                } else {
                    node.next = next.next;
                    next = node.next;
                }
            }
        }

        return head;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
