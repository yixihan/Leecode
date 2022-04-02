package com.yixihan.programming_ability_1.day10;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * <p>
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 输入: root = [1]
 * 输出: 0
 *
 * @author : yixihan
 * @create : 2022-03-20-12:07
 */
public class SumOfLeftLeaves {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getSum (root);
        return sum;
    }

    private void getSum(TreeNode node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            getSum (node.left);
        }

        if (node.right != null) {
            getSum (node.right);
        }
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
