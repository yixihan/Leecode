package com.yixihan.random.day0620;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。
 * <p>
 * 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
 * <p>
 * 输入：nums = [5,3,4,4,7,3,6,11,8,5,11]
 * 输出：3
 * 解释：执行下述几个步骤：
 * - 步骤 1 ：[5,3,4,4,7,3,6,11,8,5,11] 变为 [5,4,4,7,6,11,11]
 * - 步骤 2 ：[5,4,4,7,6,11,11] 变为 [5,4,7,11,11]
 * - 步骤 3 ：[5,4,7,11,11] 变为 [5,7,11,11]
 * [5,7,11,11] 是一个非递减数组，因此，返回 3 。
 * <p>
 * 输入：nums = [4,5,7,7,13]
 * 输出：0
 * 解释：nums 已经是一个非递减数组，因此，返回 0 。
 *
 * @author : yixihan
 * @create : 2022-06-20-15:43
 */
public class TotalSteps {

    public int totalSteps(int[] nums) {

        int n = nums.length, layer = 0;
        Node head = new Node (nums[n - 1]);
        Queue<Node> q = new ArrayDeque<> ();
        for (int i = n - 2; i >= 0; i--) {
            Node cur = new Node (nums[i], head);
            head = cur;
            if (nums[i] > nums[i + 1]) {
                q.offer (cur);
            }
        }
        while (!q.isEmpty ()) {
            layer++;
            int size = q.size ();
            while (size != 0) {
                Node node = q.poll ();
                node.next = node.next.next;
                if (node.next != null && node.val > node.next.val) {
                    q.offer (node);
                }
                size--;
            }
        }
        return layer;
    }

    private boolean judge(Node head) {
        Node node = head.next;

        while (node.next != null) {
            if (node.next.val < node.val) {
                return false;
            }
            node = node.next;
        }

        return true;
    }

    private void showNode(Node head) {
        Node node = head.next;

        while (node != null) {
            System.out.println (node.val + " => ");
            node = node.next;
        }
    }

    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
