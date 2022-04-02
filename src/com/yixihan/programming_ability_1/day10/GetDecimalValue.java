package com.yixihan.programming_ability_1.day10;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * 输入：head = [0]
 * 输出：0
 * <p>
 * 输入：head = [1]
 * 输出：1
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-03-20-12:15
 */
public class GetDecimalValue {

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder ();
        while (head != null) {
            sb.append (head.val);
            head = head.next;
        }

        return Integer.parseInt (sb.toString (), 2);
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
