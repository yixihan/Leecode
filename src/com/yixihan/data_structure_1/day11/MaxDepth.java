package com.yixihan.data_structure_1.day11;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author : yixihan
 * @create : 2022-03-20-11:55
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return getDepth (root, 0);
    }

    private int getDepth (TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max (getDepth (node.left, depth + 1), getDepth (node.right, depth + 1));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
