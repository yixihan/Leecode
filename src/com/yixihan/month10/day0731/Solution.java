package com.yixihan.month10.day0731;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-07-31-14:21
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<> ();
        queue.add (root);
        int ans = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int depth = 0;

        while (!queue.isEmpty ()) {
            depth++;
            int size = queue.size ();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add (node.right);
                }
            }
            if (maxSum <= sum) {
                if (maxSum == sum) {
                    ans = Math.min (ans, depth);
                } else {
                    maxSum = sum;
                    ans = depth;
                }
            }
        }

        return ans;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
