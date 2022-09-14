package com.yixihan.bishi.mi.q1;

/**
 * @author : yixihan
 * @create : 2022-09-14-18:41
 */

import com.yixihan.programming_ability_2.day15.AddTwoNumbers2;

import java.util.Scanner;

class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T data) {
        this.data = data;
    }

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

}

class Solution {

    ListNode<Integer> leftHead = new ListNode<> ();
    ListNode<Integer> rightHead = new ListNode<> ();
    ListNode<Integer> reverseHead = new ListNode<> ();

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        /*
        List<Integer> list = new ArrayList<> ();
        ListNode<Integer> node = head;

        while (node != null) {
            list.add(node.data);
            node = node.next;
        }

        List<Integer> reverseList = list.subList (left - 1, right);
        Collections.reverse (reverseList);
        int index = 0;
        for (int i = left - 1; i < right; i++) {
            list.set (i, reverseList.get (index++));
        }

        node = new ListNode<> ();
        head = node;

        for (int val : list) {
            node.next = new ListNode<> (val);
            node = node.next;
        }

        return head.next;
        */
        ListNode<Integer> node = head;
        ListNode<Integer> leftNode = leftHead;
        ListNode<Integer> rightNode = rightHead;
        ListNode<Integer> reverseNode = reverseHead;

        int index = 1;
        while (node != null) {
            if (index < left) {
                leftNode.next = new ListNode<> (node.data);
                leftNode = leftNode.next;
            } else if (index > right) {
                rightNode.next = new ListNode<> (node.data);
                rightNode = rightNode.next;
            } else {
                reverseNode.next = new ListNode<> (node.data);
                reverseNode = reverseNode.next;
            }
            node = node.next;
            index++;
        }

        leftHead = leftHead.next;
        rightHead = rightHead.next;
        reverseHead = reverse (reverseHead.next);
        head = new ListNode<> ();
        node = head;

        while (leftHead != null) {
            node.next = new ListNode<> (leftHead.data);
            node = node.next;
            leftHead = leftHead.next;
        }
        while (reverseHead != null) {
            node.next = new ListNode<> (reverseHead.data);
            node = node.next;
            reverseHead = reverseHead.next;
        }
        while (rightHead != null) {
            node.next = new ListNode<> (rightHead.data);
            node = node.next;
            rightHead = rightHead.next;
        }

        return head.next;
    }

    private void show (ListNode<Integer> head) {
        ListNode<Integer> node = head;
        while (node != null) {
            System.out.print (node.data + " ");
            node = node.next;
        }
        System.out.println ();
    }

    public ListNode<Integer> reverse(ListNode<Integer> head) {
        ListNode<Integer> pre = null;
        ListNode<Integer> node = head;
        ListNode<Integer> next = null;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt ();
        ListNode<Integer> head = null, head_curr = null;
        for (int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt ();
            ListNode<Integer> head_temp = new ListNode<Integer> (0);
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if (in.hasNextLine ()) {
            in.nextLine ();
        }

        int left;
        left = Integer.parseInt (in.nextLine ().trim ());

        int right;
        right = Integer.parseInt (in.nextLine ().trim ());

        res = new Solution ().reverseBetween (head, left, right);
        while (res != null) {
            System.out.print (String.valueOf (res.data) + " ");
            res = res.next;
        }
        System.out.println ();

    }
}

