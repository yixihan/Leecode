package com.yixihan.satine;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * @author : yixihan
 * @create : 2022-03-06-14:48
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode (0);
        ListNode next = head;
        int tmp = 0;

        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
            }
            if (l2 != null) {
                val += l2.val;
            }
            if (tmp > 0) {
                val += tmp;
                tmp = 0;
            }
            if (val >= 10) {
                val -= 10;
                tmp = 1;
            }

            next.next = new ListNode (val);
            next = next.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (tmp > 0) {
            next.next = new ListNode (tmp);
        }


        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
