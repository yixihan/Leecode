package com.yixihan.satine;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 说明：
 * 给定的 k 保证是有效的。
 *
 * @author : yixihan
 * @create : 2022-03-06-15:33
 */
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        List<ListNode> list = new ArrayList<> ();

        while (head != null) {
            list.add (head);
            head = head.next;
        }

        return list.get (list.size () - k).val;

    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
