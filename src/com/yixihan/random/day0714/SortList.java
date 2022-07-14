package com.yixihan.random.day0714;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 输入：head = []
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-07-14-9:35
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        List<Integer> list = new ArrayList<> ();
        ListNode node = head;

        while (node != null) {
            list.add (node.val);
            node = node.next;
        }
        Collections.sort (list);

        ListNode ans = new ListNode (list.get (0));
        node = ans;

        for (int i = 1; i < list.size (); i++) {
            node.next = new ListNode (list.get (i));
            node = node.next;
        }

        return ans;
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
