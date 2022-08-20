package com.yixihan.random.day0820;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * @author : yixihan
 * @create : 2022-08-20-8:23
 */
public class RangeSumBST {

    int low;
    int high;
    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;

        innorder (root);
        return sum;
    }

    private void innorder(TreeNode node) {
        if (node.left != null) {
            innorder (node.left);
        }

        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }

        if (node.right != null) {
            innorder (node.right);
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
