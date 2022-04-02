package com.yixihan.satine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 输入： 1->2
 * 输出： false
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 * @author : yixihan
 * @create : 2022-03-06-14:21
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {

        // 方法一 : 提取数据做对比
//        List<Integer> list = new ArrayList<>();
//        boolean flag = true;
//
//        while (head != null) {
//            list.add (head.val);
//            head = head.next;
//        }
//
//        for (int i = 0; i < list.size () / 2; i++) {
//            if (!list.get (i).equals (list.get (list.size () - i - 1))) {
//                flag = false;
//                break;
//            }
//        }
//
//        return flag;

        // 方法二 : 翻转后半链表, 对比是否相等
        ListNode fast = head;
        ListNode slow = head;

        // 找到链表中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 翻转后半部分
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        // 对比前后两段是否相等
        ListNode node = head;
        while (pre != null) {
            if (pre.val != node.val) {
                return false;
            }

            pre = pre.next;
            node = node.next;
        }

        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
