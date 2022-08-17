package com.yixihan.month11.day0817;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *
 * @author : yixihan
 * @create : 2022-08-17-8:23
 */
public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<> ();
        queue.add (root);

        while (!queue.isEmpty ()) {
            int size = queue.size ();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                sum += node.val;
                if (node.left != null) {
                    queue.add (node.left);
                }
                if (node.right != null) {
                    queue.add (node.right);
                }
            }

            ans = sum;
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
