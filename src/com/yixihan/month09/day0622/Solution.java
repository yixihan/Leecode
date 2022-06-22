package com.yixihan.month09.day0622;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 * @author : yixihan
 * @create : 2022-06-22-8:22
 */
public class Solution {

    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);

        while (!queue.isEmpty ()) {
            int size = queue.size ();
            ans = queue.peek ().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                if (node.left != null) {
                    queue.add (node.left);
                }
                if (node.right != null) {
                    queue.add (node.right);
                }
            }
        }

        return ans;
    }

    public class TreeNode {
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
