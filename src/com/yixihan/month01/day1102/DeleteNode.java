package com.yixihan.month01.day1102;

/**
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点 。
 *
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 *
 * 输入：head = [1,2,3,4], node = 3
 * 输出：[1,2,4]
 *
 * 输入：head = [0,1], node = 0
 * 输出：[1]
 *
 * 输入：head = [-3,5,-99], node = -3
 * 输出：[5,-99]
 *
 *
 * 无法访问头指针, 保证不会删除尾指针, 那么只需要将自己变成下一个节点, 将下一个节点 "kill" 即可
 *
 * @author : yixihan
 * @create : 2021-11-02-23:14
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
}

class ListNode {

    int val;
    ListNode next;


    ListNode(int x) {
        val = x;
    }

}
