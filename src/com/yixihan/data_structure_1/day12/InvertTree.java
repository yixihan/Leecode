package com.yixihan.data_structure_1.day12;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * <p>
 * 输入：root = []
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-03-21-11:17
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverse (root);
        return root;

    }

    private void reverse (TreeNode node) {
        if (node.left != null && node.right != null) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            reverse (node.left);
            reverse (node.right);
        } else if (node.left != null) {
            node.right = node.left;
            node.left = null;
            reverse (node.right);
        } else if (node.right != null) {
            node.left = node.right;
            node.right = null;
            reverse (node.left);
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
