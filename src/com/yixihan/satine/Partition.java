package com.yixihan.satine;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 
 * @author : yixihan
 * @create : 2022-03-06-15:29
 */
public class Partition {
    /**
     * 运用双指针,第一个指针落在不小于x的节点上,第二个向前移动。
     * 如果第二个指针遇到小于x的节点,交换二者的值,然后第一个指针指向next。
     * 第二个指针肯定走得更快,所以第一个指针一直处于不小于x的节点的位置，
     * 或者就是两个指针重叠,这时候还是礼貌性地交换一下罢了。
     */
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode prev = head;
        while (cur != null) {
            if (cur.val < x) {
                int tmp = prev.val;
                prev.val = cur.val;
                cur.val = tmp;
                prev = prev.next;
            }
            cur = cur.next;
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
