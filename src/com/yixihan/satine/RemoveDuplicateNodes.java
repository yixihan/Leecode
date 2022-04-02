package com.yixihan.satine;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : yixihan
 * @create : 2022-03-05-14:59
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<> ();
        ListNode node = head;
        ListNode next = head.next;
        set.add (node.val);

        while (next != null) {
            if (!set.contains (next.val)) {
                set.add (next.val);
                node = next;
                next = next.next;
            } else {
                if (next.next != null) {
                    node.next = next.next;
                    next = node.next;
                } else {
                    node.next = null;
                    break;
                }

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
