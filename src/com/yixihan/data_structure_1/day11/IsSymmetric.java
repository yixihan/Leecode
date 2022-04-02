package com.yixihan.data_structure_1.day11;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-03-20-12:00
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs (root.left, root.right);
    }

    private boolean dfs (TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }

        if (left == null) {
            return true;
        }

        if (left.val != right.val) {
            return false;
        }

        return dfs (left.left, right.right) && dfs (left.right, right.left);
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
