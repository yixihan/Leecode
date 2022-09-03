package com.yixihan.random.day0903;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * @author : yixihan
 * @create : 2022-09-03-13:21
 */
public class MinDepth {

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth (root, 1);
        return minDepth;
    }

    private void getDepth (TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            minDepth = Math.min (depth, minDepth);
            return;
        }
        if (node.left != null) {
            getDepth (node.left, depth + 1);
        }
        if (node.right != null) {
            getDepth (node.right, depth + 1);
        }
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
