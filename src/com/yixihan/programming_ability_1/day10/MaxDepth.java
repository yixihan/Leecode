package com.yixihan.programming_ability_1.day10;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author : yixihan
 * @create : 2022-03-20-12:07
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int depth = getDepth (root, 0);
        return depth;
    }

    private int getDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max (getDepth (node.left, depth + 1), getDepth (node.right, depth + 1));
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
