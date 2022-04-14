package com.yixihan.zhaoshang.day1;

import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-04-14-16:47
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode ();
        ListNode node = head;

        while (list1 != null || list2 != null) {
            int val1 = list1 == null ? 101 : list1.val;
            int val2 = list2 == null ? 101 : list2.val;
            int val = 1000;

            if (val1 <= val2 && val1 != 101) {
                val = val1;
                list1 = list1.next;
            } else if (val1 > val2 && val2 != 101 ){
                val = val2;
                list2 = list2.next;
            }

            if (val == 1000) {
                break;
            }
            node.next = new ListNode (val);
            node = node.next;

        }
        return head;
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
