package com.yixihan.data_structure_1.day8;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * @author : yixihan
 * @create : 2022-03-17-13:40
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        // 方法一 : set, 适用于非排序链表
//        if (head == null) {
//            return null;
//        }
//        Set<Integer> set = new HashSet<> ();
//        set.add (head.val);
//        ListNode pre = head;
//        ListNode node = head.next;
//
//        while (node != null) {
//            if (set.contains (node.val)) {
//                pre.next = node.next;
//                node = pre.next;
//            } else {
//                set.add (node.val);
//                pre = node;
//                node = node.next;
//            }
//        }
//
//        return head;

        // 方法二 : 适合排序链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode node = head.next;

        while (node != null) {
            if (pre.val == node.val) {
                pre.next = node.next;
                node = pre.next;
            } else {
                pre = node;
                node = node.next;
            }
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
